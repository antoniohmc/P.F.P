package com.tcc.tela_login.controller.player;

import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.service.player.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("/cadastrar")
    PlayerResponse register(@RequestBody PlayerRequest request) {

        Player player = PlayerMapper.mapToRequest(request);
        Player save = playerService.registerPlayer(player);

        return PlayerMapper.mapToResponse(save);
    }

    @GetMapping
    Collection<PlayerResponse> getPlayers() {

        return playerService.getPlayers()
                .stream()
                .map(PlayerMapper::mapToResponse)
                .toList();
    }

    @GetMapping("/username/{username}")
    ResponseEntity<PlayerResponse> getPlayerByUsername(@PathVariable String username) {

        Player player = playerService.findPlayerByUsername(username);
        return ResponseEntity.ok(PlayerMapper.mapToResponse(player));
    }

    @GetMapping("/login")
    String login(@RequestParam String username, @RequestParam String password) {
        boolean authenticated = playerService.authenticate(username, password);
        return authenticated ? "Login bem-sucedido!" : "Credenciais inválidas.";
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deletePlayer(@PathVariable String id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok("Jogador deletado com sucesso!");
    }

    //TODO: refatorar a atualização, pois nao esta atualizando os horarios de preferencia do player.

    @PutMapping(path = "/{id}")
    PlayerResponse update(@PathVariable String id, @RequestBody PlayerRequest request) {

        Player player = PlayerMapper.mapToRequest(request);
        Player atualizado = playerService.updatePlayer(id, player);

        return PlayerMapper.mapToResponse(atualizado);
    }

}