package com.tcc.tela_login.model.user;

import com.tcc.tela_login.model.game.Game;
import com.tcc.tela_login.model.game.PlataformType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "User")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "name", nullable = false, length = 20)
    private String username;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Enumerated(EnumType.STRING)
    @Column(name = "plataform_type")
    private PlataformType plataformType;

    @OneToMany(mappedBy = "user")
    private Collection<DayTimePreference> gamingTimePreferences;

    @ManyToMany
    @JoinTable(
            name = "user_games",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private Collection<Game> favoriteGames;

    @ManyToMany
    @JoinTable(
            name = "user_friendships",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private Collection<User> friends;
}
