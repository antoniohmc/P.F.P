package com.tcc.tela_login.repository;

import com.tcc.tela_login.model.Game;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, UUID> {
    Optional<Game> findByName(String nome);
}
