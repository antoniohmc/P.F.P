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
public class FollowingService {

    private final PlayerRepository playerRepository;

    public Player follow(String followerId, String playerToFollowUsername) throws NotFoundPlayer, ExistingPlayer, FollowYourself {
        var follower = findPlayerById(followerId);
        var player = findPlayerByUsername(playerToFollowUsername);

        followYourself(follower, player);
        checkFollowingListIsEmpty(follower);
        checkPlayerInFollowerList(follower, player);

        follower.getFollowing().add(player);
        return playerRepository.save(follower);
    }


    private void checkPlayerInFollowerList(Player follower, Player playerToFollow) throws ExistingPlayer {
        boolean alreadyExists = follower.getFollowing().stream()
                .anyMatch(f -> f.getUsername().equals(playerToFollow.getUsername()));

        if (alreadyExists) {
            throw new ExistingPlayer("Você Ja esta seguindo esse jogador");
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

    private void followYourself(Player follower, Player playerToFollow) throws FollowYourself {
        if (follower.getId().equals(playerToFollow.getId())) {
            throw new FollowYourself("Você nao pode seguir a si mesmo.");
        }
    }

    private void checkFollowingListIsEmpty(Player follower) {

        if (follower.getFollowing() == null) {
            follower.setFollowing(new ArrayList<>());
        }
    }
}
