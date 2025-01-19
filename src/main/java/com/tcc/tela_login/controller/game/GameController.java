package com.tcc.tela_login.controller.game;

import com.tcc.tela_login.exeptions.game.ExistingGameException;
import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.service.game.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping("/cadastrar")
    public GameResponse register(@RequestBody GameRequest request) {

        Game game = GameMapper.mapToRequest(request);
        Game save = gameService.registerGame(game);

        return GameMapper.mapToResponse(save);
    }

    @PostMapping("/cadastrar-multiplos")
    private ResponseEntity<?> registerMultiple(@RequestBody List< GameRequest> requests) {
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
