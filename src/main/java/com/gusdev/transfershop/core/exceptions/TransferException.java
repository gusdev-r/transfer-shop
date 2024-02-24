package com.gusdev.transfershop.core.exceptions;

public class TransferException extends Exception{

    private String code;

    public TransferException(String code, String message) {
        super(message);
        this.code = code;
    }
}
