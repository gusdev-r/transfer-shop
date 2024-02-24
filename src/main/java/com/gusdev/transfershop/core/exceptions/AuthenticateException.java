package com.gusdev.transfershop.core.exceptions;

public class AuthenticateException extends Exception {

    private String code;
    public AuthenticateException(String code, String message) {
        super(message);
        this.code = code;
    }
}
