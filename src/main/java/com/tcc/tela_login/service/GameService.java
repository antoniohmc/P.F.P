package com.tcc.tela_login.service;

import com.tcc.tela_login.exeptions.GameNotFoundException;
import com.tcc.tela_login.model.Game;
import com.tcc.tela_login.model.UserModel;
import com.tcc.tela_login.repository.GameRepository;
import com.tcc.tela_login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;


    public Collection<UserModel> findPlayersByGame(String name) throws GameNotFoundException {

        Optional<Game> optionalGame = gameRepository.findByName(name);
        if (optionalGame.isEmpty()) {
            throw new GameNotFoundException("Jogo não encontrado: " + name);
        }

        Game targetGame = optionalGame.get();
        return userRepository.findByFavoriteGamesContains(targetGame);
    }
}
