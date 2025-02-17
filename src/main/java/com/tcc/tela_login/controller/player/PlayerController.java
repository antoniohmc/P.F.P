package com.tcc.tela_login.controller.player;

import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.service.player.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

        Player player = PlayerMapper.mapToRequest(request);
        Player save = playerService.registerUser(player);

        return PlayerMapper.mapToResponse(save);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        boolean authenticated = playerService.authenticate(email, password);
        return authenticated ? "Login bem-sucedido!" : "Credenciais inválidas.";
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<String> deletePlayer(@RequestParam String id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok("Jogador excluido com sucesso!");
    }
}