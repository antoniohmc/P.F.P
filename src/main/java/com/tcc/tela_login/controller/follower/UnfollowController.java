package com.tcc.tela_login.controller.follower;

import com.tcc.tela_login.service.follower.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/unfollow")
public class UnfollowController {

    private final FollowService followService;

    @DeleteMapping("/{username}")
    public ResponseEntity<String> unfollow(@PathVariable String username, @RequestParam String playerToUnfollowName) {
        followService.unfollow(username, playerToUnfollowName);
        return ResponseEntity.ok("Você deixou de seguir " + playerToUnfollowName);
    }
}
