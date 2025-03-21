package com.tcc.tela_login.service.follower;

import com.tcc.tela_login.exeptions.follower.FollowYourself;
import com.tcc.tela_login.exeptions.player.ExistingPlayer;
import com.tcc.tela_login.exeptions.player.NotFoundPlayer;
import com.tcc.tela_login.model.follow.Follow;
import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.FollowRepository;
import com.tcc.tela_login.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final PlayerRepository playerRepository;
    private final FollowRepository followRepository;

    public void follow(String followerUsername, String playerToFollowUsername) throws NotFoundPlayer, ExistingPlayer, FollowYourself {
        var follower = findPlayerByUsername(followerUsername);
        var player = findPlayerByUsername(playerToFollowUsername);

        followYourself(follower, player);
        checkPlayerInFollowerList(follower, player);

        Follow follow = new Follow(null, follower.getId(), player.getId());
        followRepository.save(follow);
    }

    public void unfollow(String followerUsername, String playerFollowingUsername) throws NotFoundPlayer {
        var follower = findPlayerByUsername(followerUsername);
        var player = findPlayerByUsername(playerFollowingUsername);

        followRepository.findByFollowerIdAndFollowingId(follower.getId(), player.getId()).ifPresent(followRepository::delete);
    }

    public Collection<String> getFollowingUsernames(String playerId) {
        Collection<Follow> follows = followRepository.findByFollowerId(playerId);

        return follows.stream().map(follow -> playerRepository.findById(follow.getFollowingId())  // Busca pelo ID do jogador seguido
                        .map(Player::getUsername)
                        .orElse("Desconhecido"))
                .collect(Collectors.toList());
    }

    private void checkPlayerInFollowerList(Player follower, Player playerToFollow) throws ExistingPlayer {
        boolean alreadyExists = followRepository.findByFollowerIdAndFollowingId(follower.getId(), playerToFollow.getId()).isPresent();

        if (alreadyExists) {
            throw new ExistingPlayer("Você já está seguindo esse jogador");
        }
    }

    private Player findPlayerByUsername(String username) throws NotFoundPlayer {
        return playerRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundPlayer("Nenhum jogador encontrado com esse nome"));
    }

    private void followYourself(Player follower, Player playerToFollow) throws FollowYourself {
        if (follower.getId().equals(playerToFollow.getId())) {
            throw new FollowYourself("Você não pode seguir a si mesmo.");
        }
    }
}
