package com.tcc.tela_login.controller.follower;

import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.FollowRepository;
import com.tcc.tela_login.repository.PlayerRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FollowersMapper {

    private final PlayerRepository playerRepository;
    private final FollowRepository followRepository;

    public List<Player> getFollowing(String username) {
        var player = playerRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));

        return followRepository.findByFollowerId(player.getId()).stream()
            .map(follow -> playerRepository.findById(follow.getFollowingId()))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
    }
}
