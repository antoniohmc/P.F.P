package com.tcc.tela_login.controller.player;

import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.service.player.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        boolean authenticated = playerService.authenticate(username, password);
        return authenticated ? "Login bem-sucedido!" : "Credenciais inválidas.";
    }

    @DeleteMapping("/players")
    public ResponseEntity<String> deletePlayer(@RequestParam String id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok("Jogador excluido com sucesso!");
    }
}