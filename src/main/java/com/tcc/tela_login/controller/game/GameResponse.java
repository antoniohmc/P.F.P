package com.tcc.tela_login.controller.game;

import com.tcc.tela_login.model.game.GendersType;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Collection;

@Builder
@AllArgsConstructor
public class GameResponse {

     String id;

     String name;

     Collection<GendersType> gender;
}
