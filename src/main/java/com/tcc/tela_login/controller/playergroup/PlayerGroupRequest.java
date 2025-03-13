package com.tcc.tela_login.controller.playergroup;

import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.model.playergroup.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerGroupRequest {

    String name;

    Player adm;

    Status status;
}
