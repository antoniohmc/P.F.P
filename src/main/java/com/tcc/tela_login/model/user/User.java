package com.tcc.tela_login.model.user;

import static jakarta.persistence.GenerationType.IDENTITY;

import com.tcc.tela_login.model.game.PlataformType;
import com.tcc.tela_login.model.game.Game;
import jakarta.persistence.Column;
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

    @Column(name = "name", nullable = false, length = 20)
    private String username;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    //ainda falta fazer
    private Location location;

    //ainda falta fazer
    private PlataformType plataformType;

    //ainda falta fazer
    private Collection<DayTimePreference> gamingTimePreferences;

    //ainda falta fazer
    private Collection<Game> favoriteGames;

}
