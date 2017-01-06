package com.spock.demo;


public class IllegalOperationException extends Exception {
    private String msg;

    public IllegalOperationException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
