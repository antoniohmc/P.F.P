package com.tcc.tela_login.controller.friendship;

import com.tcc.tela_login.controller.player.PlayerResponse;
import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.service.friendship.FriendShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/friend")
public class FriendController {

    private final FriendShipService friendService;


    //TODO I need Correct. I must get the id user and next get the friend username
    @PostMapping("/{id}")
    ResponseEntity<FriendResponse> adicionarAmigo(
            @PathVariable String id,
            @RequestParam String newFriendUsername) {

        Player save = friendService.addFriend(id, newFriendUsername);
        return ResponseEntity.ok(FriendMapper.mapToResponse(save));
    }
}
