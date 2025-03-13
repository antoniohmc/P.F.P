package com.tcc.tela_login.model.playergroup;

import com.tcc.tela_login.model.player.Player;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "player_group")
@Builder
@Data
@AllArgsConstructor
public class PlayerGroup {

    @Id
    private String id;

    private Player adm;

    private String name;

    private final Integer capacity = 5;

    private Collection<Player> players;

    private Status status;

}
