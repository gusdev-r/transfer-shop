package com.gusdev.transfershop.exceptions.enums;

public enum ErrorCode {
    ON0001("This Tax Number is invalid.", "ON-0001"),
    ON0002("This Tax Number is not available.", "ON-0002"),
    ON0003("This Email is not available.", "ON-0003"),
    ON0004("There was an error creating the user", "ON-0004"),

    TR0001("Sales Clerk doesn't have this function available for use.", "TR-0001"),
    TR0002("Salary unavailable.", "TR-0002"),
    TR0003("There was an error to transfer the value.", "TR-0003"),
    TR0004("Unauthorized transfer.", "TR-0004"),
    TRP0001("Invalid Pin.", "TRP-0001"),

    WA0001("This Wallet was not found.", "WA-0001"),

    NO0001("There was an error at the User notification.", "NO-0001"),

    ATH0001("There was an authentication error.", "ATH-0001"),

    PIN0001("Transaction Pin blocked.", "PIN-0001"),
    PIN0002("Incorrect pin, %d remaining attempt(s)", "PIN-0002")

    ;
    private String message;
    private String code;

    ErrorCode(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static String pin0002GetMessage(Integer attempt){
        return String.format(PIN0002.message, attempt);
    }
}