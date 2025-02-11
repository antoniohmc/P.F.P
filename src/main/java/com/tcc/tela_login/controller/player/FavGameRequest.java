package com.tcc.tela_login.controller.player;

import com.tcc.tela_login.model.game.GendersType;
import java.util.Collection;
import java.util.UUID;

public class FavGameRequest {

    UUID id;

    String name;

    Collection<GendersType> genders;

}
