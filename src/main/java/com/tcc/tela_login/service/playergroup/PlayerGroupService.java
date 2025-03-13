package com.tcc.tela_login.service.playergroup;

import com.tcc.tela_login.model.playergroup.PlayerGroup;
import com.tcc.tela_login.repository.PlayerGroupRepository;
import com.tcc.tela_login.repository.PlayerRepository;
import com.tcc.tela_login.service.player.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerGroupService {

    private final PlayerService playerService;
    private final PlayerRepository playerRepository;
    private final PlayerGroupRepository playerGroupRepository;

    public PlayerGroup registerGroup(PlayerGroup newGroup) {

        playerGroupRepository.save(newGroup);
        return newGroup;
    }

}
