package com.tcc.tela_login.controller.friendship;

import com.tcc.tela_login.controller.player.PlayerResponse;
import com.tcc.tela_login.controller.player.PlayerRequest;
import com.tcc.tela_login.model.player.Player;

public class FriendMapper {

     static FriendResponse mapToResponse(Player player) {

        return FriendResponse.builder()
                .username(player.getUsername())
                .location(player.getLocation())
                .plataformType(player.getPlataformType())
                .gamingTimePreferences(player.getGamingTimePreferences())
                .favoriteGames(player.getFavoriteGames())
                .build();
    }

    static Player mapToRequest(FriendResquest player) {

         return Player.builder()
                 .username(player.getUsername())
                 .build();
    }
}
