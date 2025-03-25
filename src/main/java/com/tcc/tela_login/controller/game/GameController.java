package com.tcc.tela_login.controller.game;

import com.tcc.tela_login.exeptions.game.ExistingGameException;
import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.service.game.GameService;

import java.util.Collection;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador responsável pelos endpoints relacionados aos jogos.
 * Permite cadastrar jogos, buscar todos os jogos e cadastrar múltiplos jogos.
 */
@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    /**
     * Cadastra um novo jogo no sistema.
     *
     * @param request Dados do jogo a ser cadastrado.
     * @return GameResponse Objeto com as informações do jogo cadastrado.
     */
    @PostMapping("/cadastrar")
    public GameResponse register(@RequestBody GameRequest request) {
        Game game = GameMapper.mapToRequest(request);
        Game save = gameService.registerGame(game);

        return GameMapper.mapToResponse(save);
    }

    /**
     * Retorna todos os jogos cadastrados no sistema.
     *
     * @return Coleção de objetos GameResponse com os dados dos jogos.
     */
    @GetMapping
    Collection<GameResponse> getAllGames() {
        return gameService.getAllGame()
                .stream()
                .map(GameMapper::mapToResponse)
                .toList();
    }

    /**
     * Cadastra múltiplos jogos no sistema.
     *
     * @param requests Lista de jogos a serem cadastrados.
     * @return ResponseEntity Contém o status e a resposta após o cadastro dos jogos.
     */
    @PostMapping("/cadastrar-multiplos")
    private ResponseEntity<?> registerMultiple(@RequestBody List<GameRequest> requests) {
        try {

            List<Game> savedGames = requests.stream()
                    .map(GameMapper::mapToRequest)
                    .map(gameService::registerGame)
                    .toList();

            return ResponseEntity.status(HttpStatus.CREATED).body(savedGames);
        } catch (ExistingGameException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
