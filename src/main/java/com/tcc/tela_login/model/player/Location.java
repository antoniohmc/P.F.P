package com.tcc.tela_login.model.player;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.UUID;

import static jakarta.persistence.GenerationType.AUTO;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "location")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "country", nullable = false, length = 15)
    private Country country;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false, length = 30)
    private State state;

    @OneToMany
    @JoinTable(
            name = "player_location",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Collection<Player> player;
}
