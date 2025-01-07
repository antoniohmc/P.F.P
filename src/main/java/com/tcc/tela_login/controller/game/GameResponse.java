package com.tcc.tela_login.controller.game;

import com.tcc.tela_login.model.GendersType;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Collection;
import java.util.UUID;

@Builder
@AllArgsConstructor
public class GameResponse {

     UUID id;

     String username;

     Collection<GendersType> gender;
}
