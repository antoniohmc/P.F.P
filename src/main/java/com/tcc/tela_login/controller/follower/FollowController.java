package com.tcc.tela_login.controller.follower;

import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.service.follower.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/follow")
public class FollowController {

    private final FollowService followService ;


    @PostMapping("/{username}")
    ResponseEntity<FollowersResponse> follow(@PathVariable String username, @RequestParam String playerToFollowName) {

        Player save = followService.follow(username, playerToFollowName);
        return ResponseEntity.ok(FollowersMapper.mapToResponse(save));
    }

}
