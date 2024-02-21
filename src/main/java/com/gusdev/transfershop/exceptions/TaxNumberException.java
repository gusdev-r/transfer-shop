package com.gusdev.transfershop.exceptions;

public class TaxNumberException extends Exception {

    private String code;

    public TaxNumberException(String code, String message) {
        super(message);
        this.code = code;
    }
}
