package com.tcc.tela_login.exeptions.player;

public class ExistingEmailException extends RuntimeException {

    public ExistingEmailException(String message) {
        super(message);
    }
}
