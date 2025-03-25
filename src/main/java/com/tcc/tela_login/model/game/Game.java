package com.tcc.tela_login.model.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Representa a entidade Game, que armazena informações sobre os jogos.
 *
 * Um jogo é armazenado com seu nome e os tipos de gênero associados a ele.
 * A coleção é armazenada como "game".
 */
@Document(collection = "game")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    @Id
    private String id;

    private String name;

    private List<GendersType> genders;
}
