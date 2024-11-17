package com.tcc.tela_login.controller;

import com.tcc.tela_login.exeptions.ExistingEmailException;
import com.tcc.tela_login.model.Game;
import com.tcc.tela_login.model.UserModel;
import com.tcc.tela_login.repository.UserRepository;
import com.tcc.tela_login.service.UserService;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class UserController {

    @Autowired
    private UserService userService;
    private UserRepository userRepository;

    @PostMapping("/cadastrar")
    public String register(@RequestParam String username,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam Collection<Game> favoriteGames) {
        try {
            UserModel user = new UserModel(username, email, password, favoriteGames);
            userRepository.save(user);
            return user.toString();
        } catch (ExistingEmailException e) {
            return e.getMessage();
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        boolean authenticated = userService.authenticate(email, password);
        return authenticated ? "Login bem-sucedido!" : "Credenciais inválidas.";
    }


}
