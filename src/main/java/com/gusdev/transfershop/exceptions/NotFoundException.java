package com.gusdev.transfershop.exceptions;

public class NotFoundException extends Exception{
    private String code;
    public NotFoundException(String code, String message) {
        super(message);
        this.code = code;
    }
}
