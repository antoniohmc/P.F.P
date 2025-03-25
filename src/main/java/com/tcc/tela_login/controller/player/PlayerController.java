package com.tcc.tela_login.controller.player;

import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.PlayerRepository;
import com.tcc.tela_login.service.player.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Controlador responsável pelas operações relacionadas aos jogadores.
 * Inclui o cadastro, login, atualização, remoção e adição de jogos aos favoritos.
 */
@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;
    private final PlayerRepository playerRepository;

    /**
     * Cadastra um novo jogador no sistema.
     *
     * @param request Dados do jogador a ser cadastrado.
     * @return PlayerResponse Dados do jogador cadastrado.
     */
    @PostMapping("/cadastrar")
    public PlayerResponse register(@RequestBody PlayerRequest request) {
        Player player = PlayerMapper.mapToRequest(request);
        Player save = playerService.registerPlayer(player);
        return PlayerMapper.mapToResponse(save);
    }

    /**
     * Adiciona um jogo à lista de favoritos de um jogador.
     *
     * @param username Nome de usuário do jogador.
     * @param gameName Nome do jogo a ser adicionado.
     * @return ResponseEntity Mensagem de sucesso.
     */
    @PostMapping("/{username}/addNewGame")
    public ResponseEntity<?> addGameToFavoritingList(@PathVariable String username, @RequestParam String gameName) {
        playerService.addMoreFavoritingGames(username, gameName);
        return ResponseEntity.ok("Jogo adicionado com a sua lista de jogos favoritos!");
    }

    /**
     * Retorna todos os jogadores cadastrados.
     *
     * @return Coleção de jogadores no formato PlayerResponse.
     */
    @GetMapping
    public Collection<PlayerResponse> getPlayers() {
        return playerService.getPlayers()
                .stream()
                .map(PlayerMapper::mapToResponse)
                .toList();
    }

    /**
     * Retorna os dados de um jogador com base no nome de usuário.
     *
     * @param username Nome de usuário do jogador.
     * @return ResponseEntity Dados do jogador.
     */
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/username/{username}")
    public ResponseEntity<PlayerResponse> getPlayerByUsername(@PathVariable String username) {
        Player player = playerService.findPlayerByUsername(username);
        return ResponseEntity.ok(PlayerMapper.mapToResponse(player));
    }

    /**
     * Realiza o login de um jogador com base nas credenciais fornecidas.
     *
     * @param username Nome de usuário do jogador.
     * @param password Senha do jogador.
     * @return Mensagem de sucesso ou erro.
     */
    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        boolean authenticated = playerService.authenticate(username, password);
        return authenticated ? "Login bem-sucedido!" : "Credenciais inválidas.";
    }

    /**
     * Deleta um jogador com base no ID fornecido.
     *
     * @param id ID do jogador a ser deletado.
     * @return ResponseEntity Mensagem de sucesso.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable String id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok("Jogador deletado com sucesso!");
    }

    /**
     * Deleta todos os jogadores cadastrados no sistema.
     *
     * @return ResponseEntity Mensagem de sucesso.
     */
    @DeleteMapping("/delete-all")
    public ResponseEntity<String> deleteAllPlayers() {
        playerRepository.deleteAll();
        return ResponseEntity.ok("Todos os jogadores foram excluídos.");
    }

    /**
     * Atualiza os dados de um jogador com base no nome de usuário.
     *
     * @param username Nome de usuário do jogador.
     * @param request Dados do jogador a serem atualizados.
     * @return PlayerResponse Dados atualizados do jogador.
     */
    @PutMapping(path = "/{username}")
    PlayerResponse update(@PathVariable String username, @RequestBody PlayerRequest request) {

        Player player = PlayerMapper.mapToRequest(request);
        Player atualizado = playerService.updatePlayer(username, player);
        return PlayerMapper.mapToResponse(atualizado);
    }
}
