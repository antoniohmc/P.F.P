package com.tcc.tela_login.model.player;

import static jakarta.persistence.GenerationType.AUTO;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Table(name = "user_group")
@Entity
@Builder
@Data
@AllArgsConstructor
public class UserGroup {

    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID id;

    @Column(name = "capacity", nullable = false, length = 4)
    private Integer capacity;

    @ManyToMany
    @JoinTable(
            name = "player_group",
            joinColumns = @JoinColumn(name = "player_group_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Collection<Player> players;

    @Column(name = "status", nullable = false)
    private Boolean open;

}
