package com.tcc.tela_login.controller.friendship;

import com.tcc.tela_login.controller.game.GameRequest;
import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.game.PlataformType;
import com.tcc.tela_login.model.player.DayTimePreference;
import com.tcc.tela_login.model.player.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FriendResponse {

    private String username;

    Location location;

    PlataformType plataformType;

    Collection<DayTimePreference> gamingTimePreferences;

    Collection<Game> favoriteGames;
}
