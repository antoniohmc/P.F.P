package com.tcc.tela_login.controller.player;

import com.tcc.tela_login.controller.follower.FollowersResponse;
import com.tcc.tela_login.model.game.Game;

import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class PlayerResponse {

    java.lang.String id;

    java.lang.String username;

    java.lang.String email;

    java.lang.String password;

    java.lang.String country;

    String plataformType;

    Collection<Game> favoriteGames;

    Collection<FollowersResponse> following;

}
