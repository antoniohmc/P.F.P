package com.tcc.tela_login.service;

import com.tcc.tela_login.exeptions.GameNotFoundException;
import com.tcc.tela_login.model.Game;
import com.tcc.tela_login.model.UserModel;
import com.tcc.tela_login.repository.GameRepository;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    }

