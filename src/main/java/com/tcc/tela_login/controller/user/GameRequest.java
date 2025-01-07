package com.tcc.tela_login.controller.user;

import com.tcc.tela_login.model.GendersType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.Collection;

import static lombok.AccessLevel.PRIVATE;

@Value
@Builder
@AllArgsConstructor(access = PRIVATE)
public class GameRequest {

    String name;

    Collection<GendersType> genders;
}
