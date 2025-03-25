package com.tcc.tela_login.controller.player;

import static lombok.AccessLevel.PRIVATE;

import com.tcc.tela_login.controller.game.GameRequest;
import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.player.Player;
import java.util.Collection;
import lombok.NoArgsConstructor;

/**
 * Classe responsável por mapear os objetos de requisição e resposta relacionados ao jogador.
 */
@NoArgsConstructor(access = PRIVATE)
public class PlayerMapper {

    /**
     * Mapeia um jogador para a resposta PlayerResponse.
     *
     * @param player Jogador a ser mapeado.
     * @return PlayerResponse Dados do jogador para resposta.
     */
    static PlayerResponse mapToResponse(Player player) {
        return PlayerResponse.builder()
                .id(player.getId())
                .username(player.getUsername())
                .email(player.getEmail())
                .password(player.getPassword())
                .country(player.getCountry())
                .plataformType(player.getPlataformType())
                .favoriteGames(player.getFavoriteGames())
                .build();
    }

    /**
     * Mapeia os dados de PlayerRequest para um objeto Player.
     *
     * @param request Dados de entrada para criação do jogador.
     * @return Player Objeto jogador.
     */
    static Player mapToRequest(PlayerRequest request) {
        return Player.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .country(request.getCountry())
                .plataformType(request.getPlataformType())
                .favoriteGames(mapToGame(request.getFavoriteGames()))
                .build();
    }

    /**
     * Mapeia a coleção de jogos favoritos fornecida em GameRequest para objetos Game.
     *
     * @param gameRequest Lista de jogos favoritos em formato GameRequest.
     * @return Coleção de objetos Game.
     */
    static Collection<Game> mapToGame(Collection<GameRequest> gameRequest) {
        return gameRequest.stream()
                .map(request -> Game.builder()
                        .name(request.getName())
                        .build())
                .toList();
    }
}
