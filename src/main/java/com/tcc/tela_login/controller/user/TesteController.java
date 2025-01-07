package com.tcc.tela_login.controller.user;

import com.tcc.tela_login.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TesteController {

    private final UserService userService;

    @GetMapping
    public String register() {

        return "Teste";
    }
}


