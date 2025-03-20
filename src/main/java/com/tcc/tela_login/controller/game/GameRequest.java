package com.tcc.tela_login.controller.game;

import com.tcc.tela_login.model.game.GendersType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameRequest {

    String name;

    Collection<GendersType> genders;
}
