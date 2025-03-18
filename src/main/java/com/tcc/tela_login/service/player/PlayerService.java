package com.tcc.tela_login.service.player;

import com.tcc.tela_login.exeptions.game.ExistingGameException;
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

    private void checkUsernameAlreadyExisting(Player player) throws ExistingUserNameException {
        if (playerRepository.findByUsername(player.getUsername()).isPresent()) {
            throw new ExistingUserNameException("Nome de usuário já cadastrado, insira um novo nome.");
        }
    }

    private Game getGameByName(String gameName) throws ExistingGameException {
        return gameRepository.findByName(gameName)
            .orElseThrow(() -> new ExistingGameException("Jogo nao encontrado na base de dados do site."));
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

    public void deletePlayer(String playerId) throws PlayerIdNotFound {

        playerRepository.findById(playerId);

        if (!playerRepository.existsById(playerId)) {
            throw new PlayerIdNotFound("Id não encontrado");
        }
        playerRepository.deleteById(playerId);
    }

    public void deleteAllPlayers() {
        playerRepository.deleteAll();
    }

    private Player findPlayerByID(String id) throws NotFoundPlayer {

        return playerRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundPlayer("Nenhum player encontrado com esse id"));
    }

    public Collection<Player> getPlayers() {

        return playerRepository.findAll();
    }

    //TODO if you have time, implement new method that prevent to add a new username to already exist.
    //TODO if you have time, implement new method that prevent to add one game is already exist in te favorite games list.
    public Player updatePlayer(String id, Player player) {

        Player exist = findPlayerByID(id);

        Collection<Game> validGames = player.getFavoriteGames().stream()
            .map(game -> getGameByName(game.getName()))
            .toList();

        checkUsernameAlreadyExisting(player);

        Player updated = Player.builder()
            .id(exist.getId())
            .username(player.getUsername())
            .email(player.getEmail())
            .password(player.getPassword())
            .country(player.getCountry())
            .plataformType(player.getPlataformType())
            .favoriteGames(validGames)
            .following(player.getFollowing())
            .build();

        return playerRepository.save(updated);
    }


    public boolean authenticate(String username, String password) {
        Optional<Player> userOptional = playerRepository.findByUsername(username);

        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }
}
