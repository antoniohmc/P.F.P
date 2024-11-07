package com.tcc.tela_login.model;

import jakarta.persistence.Entity;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class Game {
    private UUID id;
    private String name;
    private String gender;
}
