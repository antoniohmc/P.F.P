package com.tcc.tela_login.repository;

import com.tcc.tela_login.model.player.Player;
import java.util.Collection;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para interagir com a coleção "player" no MongoDB.
 *
 * Este repositório fornece métodos para buscar e manipular dados de jogadores no banco de dados.
 */
@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

    /**
     * Encontra um jogador com base no nome de usuário.
     *
     * @param username O nome de usuário do jogador.
     * @return Um objeto Player, se existir.
     */
    Optional<Player> findByUsername(String username);

    /**
     * Encontra todos os jogadores que têm um jogo específico na sua lista de favoritos.
     *
     * @param gameName O nome do jogo favorito.
     * @return Uma coleção de objetos Player que possuem o jogo na lista de favoritos.
     */
    Collection<Player> findByFavoriteGames_Name(String gameName);
}
