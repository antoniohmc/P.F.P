package com.tcc.tela_login.model.game;

import static jakarta.persistence.GenerationType.IDENTITY;

import com.tcc.tela_login.model.GendersType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Collection;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;

    private String name;

    private Collection<GendersType> genders;
}
