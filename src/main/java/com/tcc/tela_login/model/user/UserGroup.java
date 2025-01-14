package com.tcc.tela_login.model.user;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Table(name = "User_Group")
@Entity
@Builder
@Data
@AllArgsConstructor
public class UserGroup {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;

    @Column(name = "capacity", nullable = false, length = 4)
    private Integer capacity;

    @ManyToMany
    @JoinTable(
            name = "user_group_user",
            joinColumns = @JoinColumn(name = "user_group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Collection<User> users;

    @Column(name = "status", nullable = false)
    private Boolean open;

}
