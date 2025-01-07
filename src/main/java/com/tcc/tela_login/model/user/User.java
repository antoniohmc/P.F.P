package com.tcc.tela_login.model.user;

import static jakarta.persistence.GenerationType.IDENTITY;

import com.tcc.tela_login.model.PlataformType;
import com.tcc.tela_login.model.game.Game;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "User")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;

    private String username;

    private String email;

    private String password;

    private Location location;

    private PlataformType plataformType;

    private Collection<DayTimePreference> gamingTimePreferences;

    private Collection<Game> favoriteGames;

}
