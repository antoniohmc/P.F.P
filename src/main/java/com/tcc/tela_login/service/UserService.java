package com.tcc.tela_login.service;

import com.tcc.tela_login.exeptions.ExistingEmailException;
import com.tcc.tela_login.model.user.User;
import com.tcc.tela_login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User registerUser(User usuario) throws ExistingEmailException {
        if (userRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new ExistingEmailException("Email já cadastrado, insira um novo email");
        }

        User user = new User();
        userRepository.save(user);
        return user;
    }

    public boolean authenticate(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }
}
