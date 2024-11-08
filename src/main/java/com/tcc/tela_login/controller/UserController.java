package com.tcc.tela_login.controller;

import com.tcc.tela_login.model.Game;
import com.tcc.tela_login.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String register(@RequestParam String username,
        @RequestParam String email,
        @RequestParam String password,
        @RequestParam List <Game> favoriteGames) {

    }

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password) {
        boolean authenticated = userService.authenticate(username, password);
        return authenticated ? "Login bem-sucedido!" : "Credenciais inválidas.";
    }


}
