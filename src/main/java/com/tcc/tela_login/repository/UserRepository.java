package com.tcc.tela_login.repository;

import com.tcc.tela_login.model.Game;
import com.tcc.tela_login.model.UserModel;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

    Optional<UserModel> findByEmail(String email);

    Collection<UserModel> findByFavoriteGamesContains(Game game);
}
