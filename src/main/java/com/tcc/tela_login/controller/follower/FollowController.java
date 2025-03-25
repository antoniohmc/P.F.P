package com.tcc.tela_login.controller.follower;

import com.tcc.tela_login.service.follower.FollowService;
import com.tcc.tela_login.service.player.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Controlador responsável pela gestão de seguidores.
 * Expondo os endpoints para seguir, deixar de seguir e visualizar perfis de jogadores.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/follow")
public class FollowController {

    private final FollowService followService;
    private final PlayerService playerService;

    /**
     * Segue um jogador específico.
     *
     * @param username           Nome de usuário do jogador que está seguindo.
     * @param playerToFollowName Nome do jogador a ser seguido.
     * @return ResponseEntity Mensagem de confirmação.
     */
    @PostMapping("/{username}")
    public ResponseEntity<String> follow(@PathVariable String username, @RequestParam String playerToFollowName) {
        followService.follow(username, playerToFollowName);
        return ResponseEntity.ok("Agora você está seguindo " + playerToFollowName);
    }

    /**
     * Retorna todos os jogadores seguidos por um jogador específico.
     *
     * @param followerId ID do jogador que deseja ver os jogadores que segue.
     * @return ResponseEntity Lista de usernames dos jogadores seguidos.
     */
    @GetMapping("/{followerId}/following")
    public ResponseEntity<Collection<String>> getFollowingUsernames(@PathVariable String followerId) {
        Collection<String> followingUsernames = followService.getFollowingUsernames(followerId);
        return ResponseEntity.ok(followingUsernames);
    }

    /**
     * Retorna o perfil de um jogador, incluindo seus jogos favoritos.
     *
     * @param username Nome de usuário do jogador cujo perfil será mostrado.
     * @return ResponseEntity Perfil do jogador.
     */
    @GetMapping("/profile/{username}")
    public ResponseEntity<FollowersResponse> getPlayerProfile(@PathVariable String username) {
        FollowersResponse profile = playerService.getProfile(username);
        return ResponseEntity.ok(profile);
    }
}
