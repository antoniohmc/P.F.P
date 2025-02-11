package com.tcc.tela_login.model.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.UUID;

@Document(collection = "location")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    @Id
    private String id;

    private Country country;

    private State state;


}
