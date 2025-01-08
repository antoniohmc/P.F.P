package com.tcc.tela_login.repository;

import com.tcc.tela_login.model.user.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendShipsRepository extends JpaRepository <User, UUID> {

    Optional<User> findByUsername(UUID uuid);
}
