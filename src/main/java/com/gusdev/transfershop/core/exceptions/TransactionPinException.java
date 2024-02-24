package com.gusdev.transfershop.core.exceptions;

public class TransactionPinException extends Exception{

    private String code;

    public TransactionPinException(String code, String message) {
        super(message);
        this.code = code;
    }
}
