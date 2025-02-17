package com.tcc.tela_login.controller.player;

import com.tcc.tela_login.controller.game.GameRequest;
import com.tcc.tela_login.model.game.PlataformType;
import com.tcc.tela_login.model.player.DayTimePreference;
import com.tcc.tela_login.model.player.Location;
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
