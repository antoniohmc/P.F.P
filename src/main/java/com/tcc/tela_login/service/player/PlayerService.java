package com.tcc.tela_login.service.player;

import com.tcc.tela_login.exeptions.player.ExistingFavoriteGame;
import com.tcc.tela_login.exeptions.player.ExistingPlayer;
import com.tcc.tela_login.exeptions.player.ExistingUserNameException;
import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.GameRepository;
import com.tcc.tela_login.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;


    public Player registerUser(Player player) throws ExistingUserNameException, ExistingFavoriteGame {
        checkUsernameAlreadyExisting(player);

        if (player.getFavoriteGames() != null) {
            for (Game game : player.getFavoriteGames()) {
                checkIfFavoriteGameExistsAndAdd(player.getId(), game.getId());
            }
        }

        playerRepository.save(player);
        return player;
    }


    public void checkUsernameAlreadyExisting(Player newPlayer) throws ExistingUserNameException {
        if (playerRepository.findByUsername(newPlayer.getUsername()).isPresent()) {
            throw new ExistingUserNameException("Nome de usuário já cadastrado, insira um novo nome.");
        }
    }

    public Player getPlayerById(String id) throws ExistingPlayer {
        return playerRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ExistingPlayer("Jogador nao encontrado na base de dados do site."));
    }

    public Game getGameById(String id) throws ExistingFavoriteGame {
        return gameRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ExistingFavoriteGame("Jogo nao encontrado na base de dados do site."));
    }

    public void checkIfFavoriteGameExistsAndAdd(String playerId, String gameId) throws ExistingFavoriteGame {

        Player player = getPlayerById(playerId);
        Game game = getGameById(gameId);

        boolean alreadyExists = player.getFavoriteGames().stream()
                .anyMatch(favoriteGame -> favoriteGame.getId().equals(game.getId()));

        if (!alreadyExists) {
            player.getFavoriteGames().add(game);
            playerRepository.save(player);
        } else {
            throw new ExistingFavoriteGame("Este jogo já está na lista de favoritos.");
        }
    }


    public boolean authenticate(String username, String password) {
        Optional<Player> userOptional = playerRepository.findByUsername(username);

        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }
}
