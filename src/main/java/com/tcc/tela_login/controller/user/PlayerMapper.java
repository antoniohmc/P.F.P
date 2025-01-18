package com.tcc.tela_login.controller.user;

import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.game.GendersType;
import com.tcc.tela_login.model.user.Player;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class PlayerMapper {

    static PlayerResponse mapToResponse(Player player) {

        return PlayerResponse.builder()
                .id(player.getId())
                .username(player.getUsername())
                .email(player.getEmail())
                .password(player.getPassword())
                .location(player.getLocation())
                .gamingTimePreferences(player.getGamingTimePreferences())
                .favoriteGames(player.getFavoriteGames())
                .build();
    }

    static Player mapToUser(PlayerRequest user) {

        return Player.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .location(user.getLocation())
                .plataformType(user.getPlataformType())
                .gamingTimePreferences(user.getGamingTimePreferences())
                .favoriteGames(mapToGame(user.getFavoriteGames()))
                .build();
    }

    private static Collection<Game> mapToGame(Collection<GameRequest> gameRequest) {

        return gameRequest.stream()
                .map(request -> Game.builder()
                        .name(request.getName())
                        .genders((List<GendersType>) request.getGenders())
                        .build())
                .toList();
    }
}
