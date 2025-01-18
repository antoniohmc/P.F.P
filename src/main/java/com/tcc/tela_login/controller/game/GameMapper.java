    package com.tcc.tela_login.controller.game;


    import com.tcc.tela_login.model.game.Game;

    public class GameMapper {

        static GameResponse mapToGameResponse(Game game) {

            return GameResponse.builder()
                    .id(game.getId())
                    .name(game.getName())
                    .gender(game.getGenders())
                    .build();
        }
    }
