package com.tcc.tela_login.controller.matchmaking;

import static lombok.AccessLevel.PRIVATE;

import com.tcc.tela_login.model.player.Player;
import java.util.Collection;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;

/**
 * Classe responsável por mapear a coleção de jogadores para a resposta de matchmaking.
 */
@NoArgsConstructor(access = PRIVATE)
public class MatchmakingMapper {

    /**
     * Mapeia uma coleção de jogadores para a resposta esperada de matchmaking.
     *
     * @param players Coleção de jogadores a ser mapeada.
     * @return Coleção de FindPlayerResponse com os nomes de usuário dos jogadores.
     */
    static Collection<FindPlayerResponse> mapToPlayerGame(Collection<Player> players) {
        return players.stream()
                .map(player -> new FindPlayerResponse(player.getUsername()))
                .collect(Collectors.toList());
    }
}
