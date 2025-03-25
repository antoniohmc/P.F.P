package com.tcc.tela_login.controller.game;

import com.tcc.tela_login.model.game.GendersType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * Classe de request para cadastro de jogo.
 * Contém os dados necessários para cadastrar um jogo, como nome e gêneros.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameRequest {

    private String name;

    private Collection<GendersType> genders;
}
