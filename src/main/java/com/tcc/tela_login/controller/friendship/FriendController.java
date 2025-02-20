package com.tcc.tela_login.controller.friendship;

import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.service.friendship.FriendShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/friend")
public class FriendController {

    private final FriendShipService friendService;

    @PostMapping("/add")
    FriendResponse adicionarAmigo(@RequestParam String username) {
        Player save = friendService.addFriend(username);
    }
}
