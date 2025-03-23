package com.tcc.tela_login.controller.follower;

import com.tcc.tela_login.model.game.Game;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FollowersResponse {

    private java.lang.String username;

    private java.lang.String country;

    private String plataformType;

    private Collection<Game> favoriteGames;

}
