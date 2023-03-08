package com.ltx.bank.exception;

public class AccountAbsentException extends Exception{

    public AccountAbsentException() {
    }
    public AccountAbsentException(String message) {
        super(message);
    }
}
