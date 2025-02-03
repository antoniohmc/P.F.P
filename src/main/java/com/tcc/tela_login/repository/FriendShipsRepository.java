package com.tcc.tela_login.repository;

import com.tcc.tela_login.model.player.Player;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendShipsRepository extends MongoRepository<Player, UUID> {

    Optional<Player> findByUsername(String username);
}
