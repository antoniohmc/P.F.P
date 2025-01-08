package com.tcc.tela_login.service;

import com.tcc.tela_login.exeptions.NotFoundUser;
import com.tcc.tela_login.model.user.User;
import com.tcc.tela_login.repository.FriendShipsRepository;
import com.tcc.tela_login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendShipService {

    private final FriendShipsRepository friendShipsRepository;

    private final UserRepository userRepository;

    public User addUser(User user) throws NotFoundUser {
        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
            throw new NotFoundUser("Nenhum usuario encontrado!");
        }

        return friendShipsRepository.save(user);
    }

}
