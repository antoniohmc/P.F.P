package com.tcc.tela_login.model.player;

import com.tcc.tela_login.model.game.Game;
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
    private java.lang.String id;

    private java.lang.String username;

    private java.lang.String email;

    private java.lang.String password;

    private java.lang.String country;

    private String plataformType;

    private Collection<Game> favoriteGames;

}
