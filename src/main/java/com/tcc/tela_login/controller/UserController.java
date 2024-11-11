package com.tcc.tela_login.controller;

import com.tcc.tela_login.exeptions.ExistingEmailException;
import com.tcc.tela_login.model.Game;
import com.tcc.tela_login.model.UserModel;
import com.tcc.tela_login.model.UsersList;
import com.tcc.tela_login.service.UserService;
import java.util.Collection;
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
    private UsersList users;

    @PostMapping
    public String register(@RequestParam String username,
        @RequestParam String email,
        @RequestParam String password,
        @RequestParam Collection<Game> favoriteGames) {
        try {
            Collection<UserModel> updatedUsers = users.register(email, username, password, favoriteGames);
            return updatedUsers.toString();
        } catch (ExistingEmailException e) {
            return e.getMessage();
        }
    }

    @PostMapping
    public String login(@RequestParam String email, @RequestParam String password) {
        boolean authenticated = userService.authenticate(email, password);
        return authenticated ? "Login bem-sucedido!" : "Credenciais inválidas.";
    }


}
