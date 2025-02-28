package com.tcc.tela_login.service.matchmaking;

import com.tcc.tela_login.exeptions.game.GameNotFoundException;
import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.GameRepository;
import com.tcc.tela_login.repository.PlayerRepository;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchmakingService {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;


    public Collection<Player> findPlayersByGame(String gameName) throws GameNotFoundException {

        gameRepository.findByName(gameName)
            .orElseThrow(() -> new GameNotFoundException("Esse Jogo não existe na nossa base de dados."));

        return playerRepository.findByFavoriteGames_Name(gameName);
    }

}
