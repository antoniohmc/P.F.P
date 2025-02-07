package com.tcc.tela_login.exeptions.player;

public class ExistingPlayer extends RuntimeException {
    public ExistingPlayer(String message) {
        super(message);
    }
}
