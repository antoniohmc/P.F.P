package com.tcc.tela_login.controller.user;


import com.tcc.tela_login.model.game.PlataformType;
import com.tcc.tela_login.model.user.DayTimePreference;
import com.tcc.tela_login.model.user.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRequest {

    String username;

    String email;

    String password;

    Location location;

    PlataformType plataformType;

    Collection<DayTimePreference> gamingTimePreferences;

    Collection<GameRequest> favoriteGames;
}
