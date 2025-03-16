package com.tcc.tela_login.controller.follower;

import static lombok.AccessLevel.PRIVATE;

import com.tcc.tela_login.model.player.Player;

import java.util.Collection;
import java.util.Collections;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class FollowersMapper {

    static FollowersResponse mapToResponse(Player player) {

        return FollowersResponse.builder()
                .username(player.getUsername())
                .location(player.getLocation())
                .plataformType(player.getPlataformType())
                .gamingTimePreferences(player.getGamingTimePreferences())
                .favoriteGames(player.getFavoriteGames())
                .following(mapFollowers(player))
                .followers(mapFollowers(player))
                .build();
    }


    private static Collection<Player> mapFollowers(Player player) {
        return player.getFollowing().stream()
                .map(friend -> Player.builder()
                        .username(friend.getUsername())
                        .location(friend.getLocation())
                        .plataformType(friend.getPlataformType())
                        .gamingTimePreferences(friend.getGamingTimePreferences())
                        .following(Collections.emptyList())
                        .build()
                )
                .toList();
    }
}
