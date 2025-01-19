package com.tcc.tela_login.repository;

import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.player.Player;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {

    Optional<Player> findByUsername(String username);

    Optional<Player> findByEmail(String email);

    Collection<Player> findByFavoriteGamesContains(Game game);
}
