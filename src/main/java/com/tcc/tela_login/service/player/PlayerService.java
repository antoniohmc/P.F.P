package com.tcc.tela_login.service.player;

import com.tcc.tela_login.controller.follower.FollowersResponse;
import com.tcc.tela_login.exeptions.game.ExistingGameException;
import com.tcc.tela_login.exeptions.game.GameAlreadyAddException;
import com.tcc.tela_login.exeptions.game.GameNotFoundException;
import com.tcc.tela_login.exeptions.player.ExistingUserNameException;
import com.tcc.tela_login.exeptions.player.NotFoundPlayer;
import com.tcc.tela_login.exeptions.player.PlayerIdNotFound;
import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.GameRepository;
import com.tcc.tela_login.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;

    public Player registerPlayer(Player player) throws ExistingUserNameException {
        checkUsernameAlreadyExisting(player);
        favoritingGames(player);
        return playerRepository.save(player);
    }

    public Player findPlayerByUsername(String username) {

        return playerRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundPlayer("Nenhum jogador encontrado com esse nome"));
    }

    public void deletePlayer(String playerId) throws PlayerIdNotFound {

        playerRepository.findById(playerId);

        if (!playerRepository.existsById(playerId)) {
            throw new PlayerIdNotFound("Id não encontrado");
        }
        playerRepository.deleteById(playerId);
    }

    public Collection<Player> getPlayers() {

        return playerRepository.findAll();
    }

    public FollowersResponse getProfile(String username) {
        Player player = playerRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));

        return new FollowersResponse(
                player.getUsername(),
                player.getCountry(),
                player.getPlataformType(),
                player.getFavoriteGames());
    }

    private void checkUsernameAlreadyExisting(Player player) throws ExistingUserNameException {
        Optional<Player> playerAlreadyExist = playerRepository.findByUsername(player.getUsername());

        if (playerAlreadyExist.isPresent() && !playerAlreadyExist.get().getId().equals(player.getId())) {
            throw new ExistingUserNameException("Nome já está em uso.");
        }

    }

    private Game getGameByName(String gameName) throws GameNotFoundException {
        return gameRepository.findByName(gameName)
                .orElseThrow(() -> new GameNotFoundException("Jogo nao encontrado na base de dados do site."));
    }

    public void addMoreFavoritingGames(String playerUsername, String gameName) throws GameAlreadyAddException {

        var player = findPlayerByUsername(playerUsername);
        var game = getGameByName(gameName);

        if (player.getFavoriteGames().contains(game)) {
            throw new GameAlreadyAddException("Este jogo já está na sua lista de favoritos.");
        }

        player.getFavoriteGames().add(game);
        playerRepository.save(player);
    }

    private void favoritingGames(Player player) {
        if (player.getFavoriteGames() == null) {
            return;
        }

        Collection<Game> uniqueFavoriteGames = getValidUniqueFavoriteGames(player);
        player.setFavoriteGames(uniqueFavoriteGames);
    }

    private Collection<Game> getValidUniqueFavoriteGames(Player player) {
        Collection<Game> favoriteGames = new ArrayList<>();

        for (Game game : player.getFavoriteGames()) {
            Game validGame = getGameByName(game.getName());
            if (isNotDuplicate(favoriteGames, validGame)) {
                favoriteGames.add(validGame);
            }
        }
        return favoriteGames;
    }

    private boolean isNotDuplicate(Collection<Game> games, Game game) {
        return games.stream().noneMatch(g -> g.getName().equals(game.getName()));
    }


    //TODO if you have time, implement new method that prevent to add a new username to already exist.
    //TODO if you have time, implement new method that prevent to add one game is already exist in te favorite games list.
    public Player updatePlayer(String username, Player player) {

        Player exist = findPlayerByUsername(username);

        Collection<Game> validGames = player.getFavoriteGames().stream()
                .map(game -> getGameByName(game.getName()))
                .toList();

        if (!player.getUsername().equals(exist.getUsername())) {
            checkUsernameAlreadyExisting(player);
        }

        if (player.getPassword() == null) {
            player.setPassword(exist.getPassword());
        }

        Player updated = Player.builder()
                .id(exist.getId())
                .username(player.getUsername())
                .email(player.getEmail())
                .password(player.getPassword())
                .country(player.getCountry())
                .plataformType(player.getPlataformType())
                .favoriteGames(validGames)
                .build();

        return playerRepository.save(updated);
    }


    public boolean authenticate(String username, String password) {
        Optional<Player> userOptional = playerRepository.findByUsername(username);

        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }
}
