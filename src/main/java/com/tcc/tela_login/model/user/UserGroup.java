package com.tcc.tela_login.model.user;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Collection;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Entity
@Builder
@Data
@AllArgsConstructor
public class UserGroup {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;

    private Integer capacity;

    private Collection<User> users;

    private Boolean open;

}
