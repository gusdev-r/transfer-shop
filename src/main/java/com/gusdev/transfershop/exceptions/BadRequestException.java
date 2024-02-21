package com.gusdev.transfershop.exceptions;

public class BadRequestException extends Exception {

    private String code;
    public BadRequestException(String code, String message) {
        super(message);
        this.code = code;
    }
}
