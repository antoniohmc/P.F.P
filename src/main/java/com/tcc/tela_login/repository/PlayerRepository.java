package com.tcc.tela_login.repository;

import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.player.Player;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

    Optional<Player> findByUsername(String username);

    Collection<Player> findByFavoriteGamesContains(Game game);
}
