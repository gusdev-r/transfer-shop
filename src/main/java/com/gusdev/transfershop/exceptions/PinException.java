package com.gusdev.transfershop.exceptions;

public class PinException extends Exception{

    private String code;
    public PinException(String code, String message) {
        super(message);
        this.code = code;
    }

}
