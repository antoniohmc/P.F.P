package com.tcc.tela_login.model.friendship;

import com.tcc.tela_login.model.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;
import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table(name = "FriendsShip")
@Entity
@Data
@Builder
@AllArgsConstructor
public class FriendsShip {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;

    private Collection<User> friends;

}