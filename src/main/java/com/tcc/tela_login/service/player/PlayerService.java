package com.tcc.tela_login.service.player;

import com.tcc.tela_login.exeptions.player.ExistingUserNameException;
import com.tcc.tela_login.model.player.Player;
import com.tcc.tela_login.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public Player registerUser(Player newPlayer) throws ExistingUserNameException {
        if (playerRepository.findByUsername(newPlayer.getUsername()).isPresent()) {
            throw new ExistingUserNameException("Nome de usuario já cadastrado, insira um novo nome");
        }
        playerRepository.save(newPlayer);
        return newPlayer;
    }

    public boolean authenticate(String username, String password) {
        Optional<Player> userOptional = playerRepository.findByUsername(username);

        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }
}
