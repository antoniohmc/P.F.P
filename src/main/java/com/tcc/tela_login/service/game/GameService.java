package com.tcc.tela_login.service.game;

import com.tcc.tela_login.exeptions.game.ExistingGameException;
import com.tcc.tela_login.exeptions.game.GameNotFoundException;
import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.GameRepository;
import com.tcc.tela_login.repository.PlayerRepository;

import java.util.Collection;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    private final PlayerRepository playerRepository;

    public Game registerGame(Game newGame) throws ExistingGameException {
        if (gameRepository.findByName(newGame.getName()).isPresent()) {
            throw new ExistingGameException(newGame.getName() + " Ja esta cadastrado na base de dados!");
        }

        gameRepository.save(newGame);
        return newGame;
    }


}
