package com.tcc.tela_login.model.follow;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa a entidade Follow, que armazena informações sobre o relacionamento
 * de seguimento entre usuários.
 *
 * Um usuário pode seguir outro, e essa relação é registrada na coleção "follow".
 */
@Document(collection = "follow")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Follow {

    @Id
    private String id;

    private String followerId;

    private String followingId;
}
