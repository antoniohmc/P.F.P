package com.tcc.tela_login.model;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Builder
@Data
public class User {
    private UUID id;
    private String userName;
    private String password;
}
