package com.tcc.tela_login.exeptions.game;

public class ExistingGameException extends RuntimeException {

    public ExistingGameException(String message) {
        super(message);
    }
}
