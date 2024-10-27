package com.tcc.tela_login.service;

import com.tcc.tela_login.model.User;
import com.tcc.tela_login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String userName, String password) {
        Optional<User> userOptional = userRepository.findByUserName(userName);
        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }
}
