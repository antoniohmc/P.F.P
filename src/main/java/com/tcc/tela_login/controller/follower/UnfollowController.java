package com.tcc.tela_login.controller.follower;

import com.tcc.tela_login.service.follower.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador responsável pela gestão de deixar de seguir jogadores.
 * Expondo os endpoints para deixar de seguir um jogador.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/unfollow")
public class UnfollowController {

    private final FollowService followService;

    /**
     * Deixa de seguir um jogador específico.
     *
     * @param username             Nome de usuário do jogador que deseja deixar de seguir.
     * @param playerToUnfollowName Nome do jogador a ser deixado de seguir.
     * @return ResponseEntity Mensagem de confirmação.
     */
    @DeleteMapping("/{username}")
    public ResponseEntity<String> unfollow(@PathVariable String username, @RequestParam String playerToUnfollowName) {
        followService.unfollow(username, playerToUnfollowName);
        return ResponseEntity.ok("Você deixou de seguir " + playerToUnfollowName);
    }
}
