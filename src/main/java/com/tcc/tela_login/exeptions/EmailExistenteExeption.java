package com.tcc.tela_login.exeptions;

public class EmailExistenteExeption extends RuntimeException {

    public EmailExistenteExeption(String message) {
        super(message);
    }
}
