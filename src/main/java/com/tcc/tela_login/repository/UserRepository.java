package com.tcc.tela_login.repository;

import com.tcc.tela_login.model.UserModel;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

    Optional<UserModel> findByEmail(String email);
}
