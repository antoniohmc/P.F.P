package com.tcc.tela_login.repository;

import com.tcc.tela_login.model.game.Game;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para interagir com a coleção "game" no MongoDB.
 *
 * Este repositório fornece métodos para buscar e manipular dados de jogos no banco de dados.
 */
@Repository
public interface GameRepository extends MongoRepository<Game, UUID> {

    /**
     * Encontra um jogo com base no nome.
     *
     * @param name O nome do jogo.
     * @return Um objeto Game, se existir.
     */
    Optional<Game> findByName(String name);
}
