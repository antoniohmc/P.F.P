package com.tcc.tela_login.exeptions;

public class NotFoundUser extends RuntimeException {

    public NotFoundUser(String message) {
        super(message);
    }
}
