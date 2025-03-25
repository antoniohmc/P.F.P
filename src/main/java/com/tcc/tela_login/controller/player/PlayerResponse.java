package com.tcc.tela_login.controller.player;

import com.tcc.tela_login.model.game.Game;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Classe de resposta para os dados de um jogador.
 * Contém as informações exibidas ao retornar os dados de um jogador.
 */
@Builder
@Data
@AllArgsConstructor
public class PlayerResponse {

    private String id;

    private String username;

    private String email;

    private String password;

    private String country;

    private String plataformType;

    private Collection<Game> favoriteGames;
}
