package com.tcc.tela_login.controller.follower;

import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.game.PlataformType;
import com.tcc.tela_login.model.player.DayTimePreference;
import com.tcc.tela_login.model.player.Location;
import com.tcc.tela_login.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FollowersResponse {

    private String username;

    private Location location;

    private PlataformType plataformType;

    private Collection<DayTimePreference> gamingTimePreferences;

    private Collection<Game> favoriteGames;

    private Collection<Player> following;

}
