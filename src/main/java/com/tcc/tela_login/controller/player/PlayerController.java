package com.tcc.tela_login.controller.player;

import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.PlayerRepository;
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
    private final PlayerRepository playerRepository;

    @PostMapping("/cadastrar")
    PlayerResponse register(@RequestBody PlayerRequest request) {

        Player player = PlayerMapper.mapToRequest(request);
        Player save = playerService.registerPlayer(player);

        return PlayerMapper.mapToResponse(save);
    }

    @PostMapping("/{username}/addNewGame")
    ResponseEntity<?> addGameToFavoritingList(@PathVariable String username, @RequestParam String gameName) {
        playerService.addMoreFavoritingGames(username, gameName);
        return ResponseEntity.ok("Jogo adicionado com a sua lista de jogos favoritos!");
    }

    @GetMapping
    Collection<PlayerResponse> getPlayers() {

        return playerService.getPlayers()
                .stream()
                .map(PlayerMapper::mapToResponse)
                .toList();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
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

    @DeleteMapping("/delete-all")
    ResponseEntity<String> deleteAllPlayers() {
        playerRepository.deleteAll();
        return ResponseEntity.ok("Todos os jogadores foram excluídos.");
    }


    //TODO: refatorar a atualização, pois nao esta atualizando os horarios de preferencia do player.

    @PutMapping(path = "/{username}")
    PlayerResponse update(@PathVariable String username, @RequestBody PlayerRequest request) {

        Player player = PlayerMapper.mapToRequest(request);
        Player atualizado = playerService.updatePlayer(username, player);

        return PlayerMapper.mapToResponse(atualizado);
    }

}