package com.tcc.tela_login.model.friendship;

import com.tcc.tela_login.model.player.Player;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

import static jakarta.persistence.GenerationType.AUTO;

@Table(name = "player_friendships")
@Entity
@Data
@Builder
@AllArgsConstructor
public class FriendsShip {

    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    private Player friend;

}