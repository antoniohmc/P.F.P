package com.tcc.tela_login.controller.game;

import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.game.GendersType;

import java.util.List;

public class GameMapper {

    static GameResponse mapToResponse(Game game) {

        return GameResponse.builder()
                .id(game.getId())
                .name(game.getName())
                .gender(game.getGenders())
                .build();
    }

    static Game mapToRequest(GameRequest game) {

        return Game.builder()
                .name(game.getName())
                .genders((List<GendersType>) game.getGenders())
                .build();
    }


}
