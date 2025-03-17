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


    @PostMapping("/{id}")
    ResponseEntity<FollowersResponse> follow(@PathVariable String id, @RequestParam String playerName) {

        Player save = followService.follow(id, playerName);
        return ResponseEntity.ok(FollowersMapper.mapToResponse(save));
    }

}
