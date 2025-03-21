package com.tcc.tela_login.controller.follower;

import com.tcc.tela_login.service.follower.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/follow")
public class    FollowController {

    private final FollowService followService;

    @PostMapping("/{username}")
    public ResponseEntity<String> follow(@PathVariable String username, @RequestParam String playerToFollowName) {
        followService.follow(username, playerToFollowName);
        return ResponseEntity.ok("Agora você está seguindo " + playerToFollowName);
    }

}
