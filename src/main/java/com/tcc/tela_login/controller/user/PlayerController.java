package com.tcc.tela_login.controller.user;

import com.tcc.tela_login.model.user.Player;
import com.tcc.tela_login.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("/cadastrar")
    public PlayerResponse register(@RequestBody PlayerRequest request) {

        Player player = PlayerMapper.mapToUser(request);
        Player salvo = playerService.registerUser(player);

        return PlayerMapper.mapToResponse(salvo);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        boolean authenticated = playerService.authenticate(email, password);
        return authenticated ? "Login bem-sucedido!" : "Credenciais inválidas.";
    }
}