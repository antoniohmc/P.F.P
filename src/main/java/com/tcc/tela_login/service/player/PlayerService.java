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

    private void checkUsernameAlreadyExisting(Player newPlayer) throws ExistingUserNameException {
        if (playerRepository.findByUsername(newPlayer.getUsername()).isPresent()) {
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

    public Player findPlayerByID(String id) throws NotFoundPlayer {

        return playerRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundPlayer("Nenhum player encontrado com esse id"));
    }

    public Collection<Player> getPlayers() {

        return playerRepository.findAll();
    }

    public Player updatePlayer(String id, Player player) {

        Player exist = findPlayerByID(id);

        Player updated = Player.builder()
                .id(exist.getId())
                .username(player.getUsername())
                .email(player.getEmail())
                .password(player.getPassword())
                .location(player.getLocation())
                .plataformType(player.getPlataformType())
                .gamingTimePreferences(player.getGamingTimePreferences())
                .favoriteGames(player.getFavoriteGames())
                .build();

        return playerRepository.save(updated);
    }


    public boolean authenticate(String username, String password) {
        Optional<Player> userOptional = playerRepository.findByUsername(username);

        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }
}
