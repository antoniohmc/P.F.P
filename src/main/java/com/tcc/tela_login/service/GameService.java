package com.tcc.tela_login.service;

import com.tcc.tela_login.exeptions.GameNotFoundException;
import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.user.User;
import com.tcc.tela_login.repository.GameRepository;
import com.tcc.tela_login.repository.UserRepository;
import java.util.Collection;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {


    private final GameRepository gameRepository;

    private final UserRepository userRepository;


    public Collection<User> findPlayersByGame(String name) throws GameNotFoundException {

        Optional<Game> optionalGame = gameRepository.findByName(name);
        if (optionalGame.isEmpty()) {
            throw new GameNotFoundException("Jogo não encontrado: " + name);
        }

        Game targetGame = optionalGame.get();
        return userRepository.findByFavoriteGamesContains(targetGame);
    }
}
