package com.gusdev.transfershop.core.exceptions;

public class TaxNumberException extends Exception {

    private String code;

    public TaxNumberException(String code, String message) {
        super(message);
        this.code = code;
    }
}
