package com.tcc.tela_login.controller.game;

import com.tcc.tela_login.model.game.GendersType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;

/**
 * Classe de resposta para exibição dos dados de um jogo.
 * Contém o id, nome e gêneros do jogo.
 */
@Builder
@Data
@AllArgsConstructor
public class GameResponse {

     private String id;

     private String name;

     private Collection<GendersType> gender;
}
