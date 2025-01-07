package com.tcc.tela_login.repository;

import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.user.User;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    Collection<User> findByFavoriteGamesContains(Game game);
}
