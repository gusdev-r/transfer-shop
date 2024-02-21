package com.gusdev.transfershop.exceptions;

public class EmailException extends Exception{

    private String code;
    public EmailException(String code, String message) {
        super(message);
        this.code = code;
    }
}