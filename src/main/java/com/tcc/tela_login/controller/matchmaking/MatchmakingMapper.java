package com.tcc.tela_login.controller.matchmaking;

import static lombok.AccessLevel.PRIVATE;

import com.tcc.tela_login.controller.player.PlayerResponse;
import com.tcc.tela_login.model.player.Player;
import java.util.Collection;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class MatchmakingMapper {

    static Collection<FindPlayerResponse> mapToPlayerGame(Collection<Player> players) {
        return players.stream()
            .map(player -> new FindPlayerResponse(player.getUsername()))
            .collect(Collectors.toList());
    }
}
