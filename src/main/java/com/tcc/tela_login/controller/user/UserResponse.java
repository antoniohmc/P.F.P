package com.tcc.tela_login.controller.user;

import com.tcc.tela_login.model.PlataformType;
import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.user.DayTimePreference;
import com.tcc.tela_login.model.user.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Collection;
import java.util.UUID;

@Builder
@AllArgsConstructor
public class UserResponse {
     private UUID id;

     private String username;

     private String email;

     private String password;

     private Location location;

     private PlataformType plataformType;

     private Collection<DayTimePreference> gamingTimePreferences;

     private Collection<Game> favoriteGames;
}
