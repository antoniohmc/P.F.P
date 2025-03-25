package com.tcc.tela_login.service.matchmaking;

import com.tcc.tela_login.exeptions.game.GameNotFoundException;
import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.GameRepository;
import com.tcc.tela_login.repository.PlayerRepository;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável pelo matchmaking entre jogadores baseados nos jogos que eles jogam.
 *
 * Esta classe permite buscar jogadores que jogam um determinado jogo.
 */
@Service
@RequiredArgsConstructor
public class MatchmakingService {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;

    /**
     * Encontra jogadores que possuem um jogo específico em sua lista de favoritos.
     *
     * @param gameName O nome do jogo.
     * @throws GameNotFoundException Se o jogo não for encontrado.
     * @return Uma coleção de jogadores que possuem o jogo como favorito.
     */
    public Collection<Player> findPlayersByGame(String gameName) throws GameNotFoundException {

        gameRepository.findByName(gameName)
                .orElseThrow(() -> new GameNotFoundException("Esse Jogo não existe na nossa base de dados."));

        return playerRepository.findByFavoriteGames_Name(gameName);
    }
}
