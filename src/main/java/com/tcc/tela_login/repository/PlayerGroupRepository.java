package com.tcc.tela_login.repository;

import com.tcc.tela_login.model.playergroup.PlayerGroup;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerGroupRepository extends MongoRepository<PlayerGroup, String> {

    Optional<PlayerGroup> findByName(String name);
}
