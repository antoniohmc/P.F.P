package com.tcc.tela_login.exeptions.player;

public class ExistingUserNameException extends RuntimeException {

    public ExistingUserNameException(String message) {
        super(message);
    }
}
