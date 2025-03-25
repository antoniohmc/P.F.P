package com.tcc.tela_login.controller.matchmaking;

import lombok.Builder;
import lombok.Data;

/**
 * Classe de resposta para a busca de jogadores no matchmaking.
 * Contém o nome de usuário do jogador encontrado.
 */
@Builder
@Data
public class FindPlayerResponse {

    private String username;
}
