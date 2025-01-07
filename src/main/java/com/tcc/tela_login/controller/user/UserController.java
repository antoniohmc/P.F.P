package com.tcc.tela_login.controller.user;

import com.tcc.tela_login.model.user.User;
import com.tcc.tela_login.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/cadastrar")
    public UserResponse register(@RequestBody UserRequest request) {

        User user = UserMapper.mapToUser(request);
        User salvo = userService.registerUser(user);

        return UserMapper.mapToResponse(salvo);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        boolean authenticated = userService.authenticate(email, password);
        return authenticated ? "Login bem-sucedido!" : "Credenciais inválidas.";
    }
}


//User user = userService.registerUser(usuario);
// return new ResponseEntity<>(user, HttpStatus.CREATED);