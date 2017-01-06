package com.spock.demo;


public class InsufficientFundsException extends Exception {
    private String msg;

    public InsufficientFundsException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
