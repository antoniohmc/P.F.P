package com.tcc.tela_login.model.friendship;

import com.tcc.tela_login.model.user.User;
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

import static jakarta.persistence.GenerationType.IDENTITY;

@Table(name = "user_friendships")
@Entity
@Data
@Builder
@AllArgsConstructor
public class FriendsShip {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    private User friend;

}