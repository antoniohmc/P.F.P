package com.tcc.tela_login.service.friendship;

import com.tcc.tela_login.exeptions.player.ExistingPlayer;
import com.tcc.tela_login.exeptions.player.NotFoundPlayer;
import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class FriendShipService {

    private final PlayerRepository playerRepository;

    public Player addFriend(String playerUsername, String newFriendUsername) throws NotFoundPlayer, ExistingPlayer {
        Player player = findPlayerByUsername(playerUsername);
        Player newFriend = findPlayerByUsername(newFriendUsername);

        checkFriendInFriendShip(newFriend, player);

        if (player.getFriends() == null) {
            player.setFriends(new ArrayList<>());
        }

        player.getFriends().add(newFriend);
        return playerRepository.save(player);
    }

    private void checkFriendInFriendShip(Player newFriend, Player player) throws ExistingPlayer {
        boolean alreadyExists = player.getFriends().stream()
                .anyMatch(friend -> friend.getUsername().equals(newFriend.getUsername()));

        if (alreadyExists) {
            throw new ExistingPlayer("O jogador já está adicionado à sua lista de amigos.");
        }
    }

    private Player findPlayerByUsername(String username) {
        return playerRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundPlayer("Nenhum jogador encontrado com esse nome"));
    }
}
