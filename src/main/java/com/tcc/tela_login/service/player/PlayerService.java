package com.tcc.tela_login.service.player;

import com.tcc.tela_login.exeptions.player.ExistingEmailException;
import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public Player registerUser(Player newPlayer) throws ExistingEmailException {
        if (playerRepository.findByEmail(newPlayer.getEmail()).isPresent()) {
            throw new ExistingEmailException("Email já cadastrado, insira um novo email");
        }
        playerRepository.save(newPlayer);
        return newPlayer;
    }

    public boolean authenticate(String email, String password) {
        Optional<Player> userOptional = playerRepository.findByEmail(email);

        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }
}
