package com.tcc.tela_login.model.player;

import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.game.PlataformType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;


@Document(collection = "player")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    private String id;

    private String username;

    private String email;

    private String password;

    private Location location;

    private PlataformType plataformType;

    private Collection<DayTimePreference> gamingTimePreferences;

    private Collection<Game> favoriteGames;

    private Collection<Player> following;

    private Collection<PlayerGroup> playerGroups;
}
