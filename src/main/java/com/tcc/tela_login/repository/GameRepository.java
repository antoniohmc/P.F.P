package com.tcc.tela_login.repository;

import com.tcc.tela_login.model.game.Game;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    Optional<Game> findByName(String name);
}
