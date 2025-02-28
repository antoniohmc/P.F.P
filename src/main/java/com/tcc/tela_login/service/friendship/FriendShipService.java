package com.tcc.tela_login.service.friendship;

import com.tcc.tela_login.exeptions.freindship.AddYourselfException;
import com.tcc.tela_login.exeptions.player.ExistingPlayer;
import com.tcc.tela_login.exeptions.player.NotFoundPlayer;
import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.PlayerRepository;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendShipService {

    private final PlayerRepository playerRepository;

    public Player addFriend(String playerId, String friendUsername) throws NotFoundPlayer, ExistingPlayer {
        Player player = findPlayerById(playerId);
        Player friend = findPlayerByUsername(friendUsername);

        addYourself(player,friend);
        checkFriendListIsEmpty(player);
        checkFriendInFriendShip(friend, player);
        player.getFriends().add(friend);
        return playerRepository.save(player);
    }


    private void checkFriendInFriendShip(Player newFriend, Player player) throws ExistingPlayer {
        boolean alreadyExists = player.getFriends().stream()
            .anyMatch(friend -> friend.getUsername().equals(newFriend.getUsername()));

        if (alreadyExists) {
            throw new ExistingPlayer("O jogador já está adicionado à sua lista de amigos.");
        }
    }

    private void addYourself(Player newFriend, Player player) throws AddYourselfException {
        if (newFriend.getUsername().equals(player.getUsername())) {
            throw new AddYourselfException("Não é possivel adicionar você mesmo como amigo");
        }
    }

    private Player findPlayerById(String playerId) throws NotFoundPlayer {
        return playerRepository.findById(playerId)
            .orElseThrow(() -> new NotFoundPlayer("Nenhum jogador existente com esse Id"));
    }

    private Player findPlayerByUsername(String username) throws NotFoundPlayer {
        return playerRepository.findByUsername(username)
            .orElseThrow(() -> new NotFoundPlayer("Nenhum jogador encontrado com esse nome"));
    }

    private void checkFriendListIsEmpty(Player player) {

        if (player.getFriends() == null) {
            player.setFriends(new ArrayList<>());
        }
    }
}
