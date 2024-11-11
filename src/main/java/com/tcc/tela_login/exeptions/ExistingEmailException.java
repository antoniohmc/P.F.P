package com.tcc.tela_login.exeptions;

public class ExistingEmailException extends RuntimeException {

    public ExistingEmailException(String message) {
        super(message);
    }
}
