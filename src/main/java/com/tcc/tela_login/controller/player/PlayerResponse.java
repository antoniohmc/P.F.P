package com.tcc.tela_login.controller.player;

import com.tcc.tela_login.model.game.PlataformType;
import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.player.DayTimePreference;
import com.tcc.tela_login.model.player.Location;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class PlayerResponse {

    private String id;

    private String username;

    private String email;

    private String password;

    private Location location;

    private PlataformType plataformType;

    private Collection<DayTimePreference> gamingTimePreferences;

    private Collection<Game> favoriteGames;
}
