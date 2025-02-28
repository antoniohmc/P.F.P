package com.tcc.tela_login.repository;

import com.tcc.tela_login.model.player.Player;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

    Optional<Player> findByUsername(String username);

    Collection<Player> findByFavoriteGames_Name(String gameName);
}
