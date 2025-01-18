package com.tcc.tela_login.service;

import com.tcc.tela_login.exeptions.ExistingEmailException;
import com.tcc.tela_login.model.user.Player;
import com.tcc.tela_login.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public Player registerUser(Player usuario) throws ExistingEmailException {
        if (playerRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new ExistingEmailException("Email já cadastrado, insira um novo email");
        }

        Player player = new Player();
        playerRepository.save(player);
        return player;
    }

    public boolean authenticate(String email, String password) {
        Optional<Player> userOptional = playerRepository.findByEmail(email);

        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }
}
