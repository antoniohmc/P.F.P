package com.tcc.tela_login.repository;

import com.tcc.tela_login.model.follow.Follow;
import java.util.Collection;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

/**
 * Repositório para interagir com a coleção "follow" no MongoDB.
 *
 * Este repositório fornece métodos para buscar informações sobre os relacionamentos
 * de seguimento entre os jogadores.
 */
public interface FollowRepository extends MongoRepository<Follow, String> {

    /**
     * Encontra todos os relacionamentos de seguimento de um usuário.
     *
     * @param followerId O ID do usuário seguidor.
     * @return Uma coleção de objetos Follow.
     */
    Collection<Follow> findByFollowerId(String followerId);

    /**
     * Encontra todos os relacionamentos de seguimento de um usuário que está sendo seguido.
     *
     * @param followingId O ID do usuário seguido.
     * @return Uma coleção de objetos Follow.
     */
    Collection<Follow> findByFollowingId(String followingId);

    /**
     * Encontra um relacionamento de seguimento específico entre dois usuários.
     *
     * @param followerId O ID do seguidor.
     * @param followingId O ID do seguido.
     * @return Um objeto Follow, se existir.
     */
    Optional<Follow> findByFollowerIdAndFollowingId(String followerId, String followingId);
}
