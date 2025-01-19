package com.tcc.tela_login.service.player;

import com.tcc.tela_login.exeptions.player.NotFoundPlayer;
import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.FriendShipsRepository;
import com.tcc.tela_login.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendShipService {

    private final FriendShipsRepository friendShipsRepository;

    private final PlayerRepository playerRepository;

    public Player addFriend(Player player) throws NotFoundPlayer {
        if (playerRepository.findByUsername(player.getUsername()).isEmpty()) {
            throw new NotFoundPlayer("Nenhum usuario encontrado!");
        }

        return friendShipsRepository.save(player);
    }

}
