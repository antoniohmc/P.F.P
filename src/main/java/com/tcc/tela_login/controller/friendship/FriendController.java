package com.tcc.tela_login.controller.friendship;

import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.service.friendship.FriendShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/friend")
public class FriendController {

    private final FriendShipService friendService;


    //TODO I need Correct. I must get the id user and next get the friend username
    @PostMapping("/add")
    FriendResponse adicionarAmigo(@RequestParam String playerUsername, @RequestParam String newFriendUsername) {
        Player save = friendService.addFriend(playerUsername, newFriendUsername);

        return FriendMapper.mapToResponse(save);
    }
}
