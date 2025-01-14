package com.tcc.tela_login.model.user;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Collection;
import java.util.UUID;

import jakarta.persistence.Table;
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

    //ainda falta fazer
    private Collection<User> users;

    @Column(name = "status", nullable = false)
    private Boolean open;

}
