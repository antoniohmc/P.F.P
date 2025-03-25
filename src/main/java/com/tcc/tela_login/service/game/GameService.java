package com.tcc.tela_login.service.game;

import com.tcc.tela_login.exeptions.game.ExistingGameException;
import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.repository.GameRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável pelas operações relacionadas aos jogos.
 *
 * Esta classe permite o cadastro de novos jogos, bem como a obtenção de uma lista de todos os jogos cadastrados.
 */
@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    /**
     * Registra um novo jogo na base de dados.
     *
     * @param newGame O objeto Game representando o novo jogo.
     * @throws ExistingGameException Se o jogo já estiver cadastrado.
     * @return O jogo registrado.
     */
    public Game registerGame(Game newGame) throws ExistingGameException {
        if (gameRepository.findByName(newGame.getName()).isPresent()) {
            throw new ExistingGameException(newGame.getName() + " Já está cadastrado na base de dados!");
        }

        gameRepository.save(newGame);
        return newGame;
    }

    /**
     * Retorna todos os jogos cadastrados.
     *
     * @return Uma lista de objetos Game.
     */
    public List<Game> getAllGame() {
        return gameRepository.findAll();
    }
}
