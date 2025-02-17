package com.tcc.tela_login.controller.player;

import com.tcc.tela_login.controller.game.GameRequest;
import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.game.GendersType;
import com.tcc.tela_login.model.player.Player;
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
                .plataformType(player.getPlataformType())
                .gamingTimePreferences(player.getGamingTimePreferences())
                .favoriteGames(player.getFavoriteGames())
                .build();
    }

    static Player mapToRequest(PlayerRequest player) {

        return Player.builder()
                .username(player.getUsername())
                .email(player.getEmail())
                .password(player.getPassword())
                .location(player.getLocation())
                .plataformType(player.getPlataformType())
                .gamingTimePreferences(player.getGamingTimePreferences())
                .favoriteGames(mapToGame(player.getFavoriteGames()))
                .build();
    }

     static Collection<Game> mapToGame(Collection<GameRequest> gameRequest) {

        return gameRequest.stream()
                .map(request -> Game.builder()  
                        .name(request.getName())
                        .genders((List<GendersType>) request.getGenders())
                        .build())
                .toList();
    }


}
