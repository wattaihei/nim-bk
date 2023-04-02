package com.puzzle.nim.config;

public class InvalidOperationException extends Exception {
    public String errMsg;

    public InvalidOperationException(String msg) {
        errMsg = msg;
    }
}
