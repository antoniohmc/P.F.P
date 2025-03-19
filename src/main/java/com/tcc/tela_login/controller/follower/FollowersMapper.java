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
                .country(player.getCountry())
                .plataformType(player.getPlataformType())
                .favoriteGames(player.getFavoriteGames())
                .following(mapPlayersToFollowing(player))
                .build();
    }


    private static Collection<Player> mapPlayersToFollowing(Player player) {
        return player.getFollowing().stream()
                .map(friend -> Player.builder()
                        .username(friend.getUsername())
                        .country(friend.getCountry())
                        .plataformType(friend.getPlataformType())
                        .following(Collections.emptyList())
                        .build()
                )
                .toList();
    }
}
