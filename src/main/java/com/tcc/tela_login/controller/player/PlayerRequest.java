package com.tcc.tela_login.controller.player;

import com.tcc.tela_login.controller.game.GameRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerRequest {

    String username;

    String email;

    String password;

    String country;

    String plataformType;

    Collection<GameRequest> favoriteGames;
}
