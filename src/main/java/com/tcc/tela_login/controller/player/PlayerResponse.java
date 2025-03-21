package com.tcc.tela_login.controller.player;

import com.tcc.tela_login.controller.follower.FollowersResponse;
import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.game.PlataformType;
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

    PlataformType plataformType;

    Collection<Game> favoriteGames;

    Collection<FollowersResponse> following;

}
