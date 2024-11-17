package com.tcc.tela_login.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Table(name = "User")
@Entity
@Builder
@Data
@AllArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;
    private String username;
    private String email;
    private String password;
    private Collection<Game> favoriteGames;

    public UserModel(String username, String email, String password, Collection<Game> favoriteGames) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.favoriteGames = favoriteGames;
    }
}
