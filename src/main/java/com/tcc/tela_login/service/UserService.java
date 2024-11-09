package com.tcc.tela_login.service;

import com.tcc.tela_login.exeptions.EmailExistenteExeption;
import com.tcc.tela_login.model.Game;
import com.tcc.tela_login.model.UserModel;
import com.tcc.tela_login.model.UsersList;
import com.tcc.tela_login.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private UsersList users;

    public boolean checkRegister(String email, String username, String password, List<Game> favoriteGames) throws EmailExistenteExeption {
        for (UserModel user : users.getUsers()) {
            if (user.getEmail().equals(email))
                throw new EmailExistenteExeption("Email ja cadastrado, insira um novo email");
        }
        users.register(email,username, password, favoriteGames);
        return false;
    }


    public boolean authenticate(String email, String password) {
        Optional<UserModel> userOptional = userRepository.findByEmail(email);
        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }


}
