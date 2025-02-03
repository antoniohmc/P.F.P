package com.tcc.tela_login.repository;

import com.tcc.tela_login.model.game.Game;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends MongoRepository<Game, UUID> {

    Optional<Game> findByName(String name);
}
