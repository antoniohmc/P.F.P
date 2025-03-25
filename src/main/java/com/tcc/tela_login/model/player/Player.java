package com.tcc.tela_login.model.player;

import com.tcc.tela_login.model.game.Game;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

/**
 * Representa a entidade Player, que armazena informações sobre os jogadores.
 *
 * Cada jogador possui um nome de usuário, e-mail, senha, país, tipo de plataforma,
 * e uma coleção de jogos favoritos.
 * A coleção é armazenada como "player".
 */
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
