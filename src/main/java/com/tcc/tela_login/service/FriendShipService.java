package com.tcc.tela_login.service;

import com.tcc.tela_login.exeptions.NotFoundUser;
import com.tcc.tela_login.model.user.Player;
import com.tcc.tela_login.repository.FriendShipsRepository;
import com.tcc.tela_login.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendShipService {

    private final FriendShipsRepository friendShipsRepository;

    private final PlayerRepository playerRepository;

    public Player addUser(Player player) throws NotFoundUser {
        if (playerRepository.findByUsername(player.getUsername()).isEmpty()) {
            throw new NotFoundUser("Nenhum usuario encontrado!");
        }

        return friendShipsRepository.save(player);
    }

}
