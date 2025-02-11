package com.tcc.tela_login.service.player;

import com.tcc.tela_login.exeptions.game.ExistingGameException;
import com.tcc.tela_login.exeptions.player.ExistingFavoriteGame;
import com.tcc.tela_login.exeptions.player.ExistingUserNameException;
import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.GameRepository;
import com.tcc.tela_login.repository.PlayerRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;


    public Player registerUser(Player player) throws ExistingUserNameException, ExistingFavoriteGame {

        if (player.getFavoriteGames() != null) {
            for (Game game : player.getFavoriteGames()) {
                checkIfFavoriteGameExists(player, game);
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

    public Game getGameByName(String gameName) throws ExistingGameException {
        return gameRepository.findByName(gameName)
            .orElseThrow(() -> new ExistingGameException("Jogo nao encontrado na base de dados do site."));
    }

    public void checkIfFavoriteGameExists(Player player, Game game) throws ExistingFavoriteGame {

        getGameByName(game.getName());

        boolean alreadyExists = player.getFavoriteGames().stream()
            .anyMatch(favoriteGame -> favoriteGame.getName().equals(game.getName()));

        if (!alreadyExists) {
            player.getFavoriteGames().add(game);
        } else {
            throw new ExistingFavoriteGame("Este jogo já está na lista de favoritos.");
        }
    }


    public boolean authenticate(String username, String password) {
        Optional<Player> userOptional = playerRepository.findByUsername(username);

        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }
}
