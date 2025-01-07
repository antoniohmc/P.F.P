package com.tcc.tela_login.controller.user;

import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.user.User;
import lombok.NoArgsConstructor;

import java.util.Collection;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserMapper {

    static UserResponse mapToResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .location(user.getLocation())
                .gamingTimePreferences(user.getGamingTimePreferences())
                .favoriteGames(user.getFavoriteGames())
                .build();
    }

    static User mapToUser(UserRequest user) {

        return User.builder()
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
                        .genders(request.getGenders())
                        .build())
                .toList();
    }
}
