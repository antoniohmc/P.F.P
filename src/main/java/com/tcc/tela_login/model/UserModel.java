package com.tcc.tela_login.model;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Builder
@Data
public class UserModel {
    private UUID id;
    private String username;
    private String password;
}
