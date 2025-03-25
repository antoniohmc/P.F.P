package com.tcc.tela_login.controller.game;

import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.game.GendersType;

import java.util.List;

/**
 * Classe responsável por mapear objetos de request e response relacionados aos jogos.
 */
public class GameMapper {

    /**
     * Mapeia um objeto Game para um objeto GameResponse.
     *
     * @param game Jogo a ser mapeado.
     * @return GameResponse Objeto de resposta com os dados do jogo.
     */
    static GameResponse mapToResponse(Game game) {
        return GameResponse.builder()
                .id(game.getId())
                .name(game.getName())
                .gender(game.getGenders())
                .build();
    }

    /**
     * Mapeia um objeto GameRequest para um objeto Game.
     *
     * @param game Jogo a ser mapeado.
     * @return Game Objeto de jogo que será cadastrado.
     */
    static Game mapToRequest(GameRequest game) {
        return Game.builder()
                .name(game.getName())
                .genders((List<GendersType>) game.getGenders())
                .build();
    }
}
