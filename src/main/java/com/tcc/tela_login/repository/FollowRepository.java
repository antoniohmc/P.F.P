package com.tcc.tela_login.repository;

import com.tcc.tela_login.model.follow.Follow;
import java.util.Collection;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FollowRepository extends MongoRepository<Follow, String> {

    Collection<Follow> findByFollowerId(String followerId);

    Collection<Follow> findByFollowingId(String followingId);

    Optional<Follow> findByFollowerIdAndFollowingId(String followerId, String followingId);
}
