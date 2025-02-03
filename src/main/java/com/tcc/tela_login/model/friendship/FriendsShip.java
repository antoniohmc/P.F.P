package com.tcc.tela_login.model.friendship;

import com.tcc.tela_login.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document(collection = "player_friendships")
@Data
@Builder
@AllArgsConstructor
public class FriendsShip {

    @Id
    private UUID id;

    private Player player;

    private Player friend;

}