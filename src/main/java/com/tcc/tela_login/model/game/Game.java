package com.tcc.tela_login.model.game;

import com.tcc.tela_login.model.user.User;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Game")
@Data
@Builder
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ElementCollection(targetClass = GendersType.class)
    @CollectionTable(name = "game_genders", joinColumns = @JoinColumn(name = "game_id"))
    @Enumerated(EnumType.STRING)
    private List<GendersType> genders;

    @ManyToMany
    @JoinTable(
            name = "game_users",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Collection<User> users;
}
