package com.tcc.tela_login.service.player;

import com.tcc.tela_login.exeptions.game.GameNotFoundException;
import com.tcc.tela_login.exeptions.player.ExistingFavoriteGame;
import com.tcc.tela_login.exeptions.player.ExistingUserNameException;
import com.tcc.tela_login.exeptions.player.NotFoundPlayer;
import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.GameRepository;
import com.tcc.tela_login.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;


    public Player registerUser(Player newPlayer) throws ExistingUserNameException {
        if (playerRepository.findByUsername(newPlayer.getUsername()).isPresent()) {
            throw new ExistingUserNameException("Nome de usuario já cadastrado, insira um novo nome");
        }
        playerRepository.save(newPlayer);
        return newPlayer;
    }


//    public Player addFavoriteGames(Integer playerId, Integer gameId) throws ExistingFavoriteGame, GameNotFoundException, NotFoundPlayer {
//
//        Player player = playerRepository.findById(playerId).orElseThrow(() -> new NotFoundPlayer("Jogador não encontrado"));
//
//        Game game = gameRepository.findById(gameId).orElseThrow(() -> new GameNotFoundException("Jogo não encontrado"));
//
//        if (player.getFavoriteGames().contains(game)) {
//            throw new ExistingFavoriteGame("Jogo já está na lista de favoritos");
//        }
//
//        player.getFavoriteGames().add(game);
//        return player;
//    }

    public boolean authenticate(String username, String password) {
        Optional<Player> userOptional = playerRepository.findByUsername(username);

        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }
}
