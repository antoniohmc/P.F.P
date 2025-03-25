package com.tcc.tela_login.controller.player;

import com.tcc.tela_login.controller.game.GameRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * Classe de solicitação de cadastro de jogador.
 * Contém os dados necessários para cadastrar um novo jogador.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerRequest {

    private String username;

    private String email;

    private String password;

    private String country;

    private String plataformType;

    private Collection<GameRequest> favoriteGames;
}
