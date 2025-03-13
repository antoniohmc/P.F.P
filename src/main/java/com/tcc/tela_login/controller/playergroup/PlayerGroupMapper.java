package com.tcc.tela_login.controller.playergroup;

import com.tcc.tela_login.model.playergroup.PlayerGroup;

public class PlayerGroupMapper {

    static PlayerGroup mapToRequest(PlayerGroupRequest request) {

        return PlayerGroup.builder()
            .name(request.getName())
            .adm(request.getAdm())
            .status(request.getStatus())
            .build();
    }

}
