package com.tcc.tela_login.controller.follower;

import com.tcc.tela_login.service.follower.FollowService;
import com.tcc.tela_login.service.player.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/follow")
public class FollowController {

    private final FollowService followService;
    private final PlayerService playerService;

    @PostMapping("/{username}")
    public ResponseEntity<String> follow(@PathVariable String username, @RequestParam String playerToFollowName) {
        followService.follow(username, playerToFollowName);
        return ResponseEntity.ok("Agora você está seguindo " + playerToFollowName);
    }

    @GetMapping("/{followerId}/following")
    public ResponseEntity<Collection<String>> getFollowingUsernames(@PathVariable String followerId) {
        Collection<String> followingUsernames = followService.getFollowingUsernames(followerId);
        return ResponseEntity.ok(followingUsernames);
    }

    @GetMapping("/profile/{username}")
    public ResponseEntity<FollowersResponse> getPlayerProfile(@PathVariable String username) {
        FollowersResponse profile = playerService.getProfile(username);
        return ResponseEntity.ok(profile);
    }

}
