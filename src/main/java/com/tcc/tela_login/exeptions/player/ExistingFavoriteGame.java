package com.tcc.tela_login.exeptions.player;

public class ExistingFavoriteGame extends RuntimeException {

    public ExistingFavoriteGame(String message) {
        super(message);
    }
}
