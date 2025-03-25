package com.tcc.tela_login.controller.matchmaking;

import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.service.matchmaking.MatchmakingService;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador responsável pelos endpoints relacionados ao matchmaking.
 * Permite filtrar e buscar jogadores por jogo.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("Matchmaking")
public class MatchmakingController {

    private final MatchmakingService matchmakingService;

    /**
     * Busca jogadores que possuem um jogo favorito e os retorna.
     *
     * @param gameName Nome do jogo favorito para buscar jogadores.
     * @return ResponseEntity Coleção de jogadores encontrados.
     */
    @GetMapping("/filtrar")
    public ResponseEntity<Collection<FindPlayerResponse>> matchmakingPlayers(@RequestParam String gameName) {

        Collection<Player> players = matchmakingService.findPlayersByGame(gameName);

        return ResponseEntity.ok(MatchmakingMapper.mapToPlayerGame(players));
    }
}
