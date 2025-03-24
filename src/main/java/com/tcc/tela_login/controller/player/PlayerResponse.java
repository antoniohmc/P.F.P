package com.tcc.tela_login.controller.player;

import com.tcc.tela_login.model.game.Game;

import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class PlayerResponse {

    String id;

    String username;

    String email;

    String password;

    String country;

    String plataformType;

    Collection<Game> favoriteGames;


}
