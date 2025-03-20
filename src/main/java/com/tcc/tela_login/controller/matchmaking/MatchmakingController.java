package com.tcc.tela_login.controller.matchmaking;

import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.PlayerRepository;
import com.tcc.tela_login.service.matchmaking.MatchmakingService;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("Matchmaking")
public class MatchmakingController {

    private final MatchmakingService matchmakingService;



    @GetMapping("/filtrar")
    public ResponseEntity<Collection<FindPlayerResponse>> matchmakingPlayers(@RequestParam String gameName) {
        Collection<Player> players = matchmakingService.findPlayersByGame(gameName);

        return ResponseEntity.ok(MatchmakingMapper.mapToPlayerGame(players));
    }
}
