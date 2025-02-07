package com.tcc.tela_login.model.player;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "user_group")
@Builder
@Data
@AllArgsConstructor
public class UserGroup {

    @Id
    private String id;

    private Integer capacity;

    private Collection<Player> players;

    private Boolean open;

}
