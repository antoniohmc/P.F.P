package com.tcc.tela_login.service.follower;

import com.tcc.tela_login.exeptions.follower.FollowYourself;
import com.tcc.tela_login.exeptions.player.ExistingPlayer;
import com.tcc.tela_login.exeptions.player.NotFoundPlayer;
import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class FollowerService {

    private final PlayerRepository playerRepository;

    public Player follow(String playerId, String followerUsername) throws NotFoundPlayer, ExistingPlayer, FollowYourself {
        var player = findPlayerById(playerId);
        var follower = findPlayerByUsername(followerUsername);

        checkEverything(player, follower);
        player.getFollowing().add(follower);
        return playerRepository.save(player);
    }


    private void checkFollowerInFollowerList(Player newFollower, Player player) throws ExistingPlayer {
        boolean alreadyExists = player.getFollowing().stream()
                .anyMatch(follower -> follower.getUsername().equals(newFollower.getUsername()));

        if (alreadyExists) {
            throw new ExistingPlayer("Você Ja esta seguindo esse jogador");
        }
    }

    private void checkEverything(Player player, Player follower) throws NotFoundPlayer, ExistingPlayer, FollowYourself {
        followYourself(player, follower);
        checkFollowerListIsEmpty(player);
        checkFollowerInFollowerList(follower, player);
    }


    private Player findPlayerById(String playerId) throws NotFoundPlayer {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new NotFoundPlayer("Nenhum jogador existente com esse Id"));
    }

    private Player findPlayerByUsername(String username) throws NotFoundPlayer {
        return playerRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundPlayer("Nenhum jogador encontrado com esse nome"));
    }

    private void followYourself(Player player, Player follower) throws FollowYourself {
        if (player.getId().equals(follower)) {
            throw new FollowYourself("Você nao pode seguir a si mesmo.");
        }
    }

    private void checkFollowerListIsEmpty(Player player) {

        if (player.getFollowing() == null) {
            player.setFollowing(new ArrayList<>());
        }
    }
}
