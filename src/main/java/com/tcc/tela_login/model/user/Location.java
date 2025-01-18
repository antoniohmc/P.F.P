package com.tcc.tela_login.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "location")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "country", nullable = false, length = 15)
    private Country country;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false, length = 30)
    private State state;
}
