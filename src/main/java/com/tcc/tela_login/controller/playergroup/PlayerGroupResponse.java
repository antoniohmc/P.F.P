package com.tcc.tela_login.controller.playergroup;

import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.model.playergroup.Status;
import java.util.Collection;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


public class PlayerGroupResponse {

    private String Id;

    private Player adm;

    private Integer capacity;

    private Collection<Player> players;

    private Status status;
}
