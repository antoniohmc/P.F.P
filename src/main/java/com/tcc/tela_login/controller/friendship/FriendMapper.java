package com.tcc.tela_login.controller.friendship;

import static lombok.AccessLevel.PRIVATE;

import com.tcc.tela_login.model.player.Player;

import java.util.Collection;
import java.util.Collections;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class FriendMapper {

    static FriendResponse mapToResponse(Player player) {

        return FriendResponse.builder()
                .username(player.getUsername())
                .location(player.getLocation())
                .plataformType(player.getPlataformType())
                .gamingTimePreferences(player.getGamingTimePreferences())
                .favoriteGames(player.getFavoriteGames())
                .friends(mapFriends(player))
                .build();
    }


    private static Collection<Player> mapFriends(Player player) {
        return player.getFriends().stream()
                .map(friend -> Player.builder()
                        .username(friend.getUsername())
                        .location(friend.getLocation())
                        .plataformType(friend.getPlataformType())
                        .gamingTimePreferences(friend.getGamingTimePreferences())
                        .friends(Collections.emptyList())
                        .build()
                )
                .toList();
    }
}
