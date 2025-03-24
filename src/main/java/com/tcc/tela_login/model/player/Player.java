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
    private String id;

    private String username;

    private String email;

    private String password;

    private String country;

    private String plataformType;

    private Collection<Game> favoriteGames;

}
