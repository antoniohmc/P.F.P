package com.tcc.tela_login.service;

import com.tcc.tela_login.exeptions.ExistingEmailException;
import com.tcc.tela_login.model.Game;
import com.tcc.tela_login.model.UserModel;
import com.tcc.tela_login.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(String email, String username, String password, List<Game> favoriteGames) throws ExistingEmailException {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new ExistingEmailException("Email já cadastrado, insira um novo email");
        }

        UserModel user = new UserModel(email, username, password, favoriteGames);
        userRepository.save(user);
    }

    public boolean authenticate(String email, String password) {
        Optional<UserModel> userOptional = userRepository.findByEmail(email);

        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }
}
