package com.informed.trading.exception;

public class InvalidPostcodeException extends IllegalArgumentException {
    public InvalidPostcodeException(String s) {
        super(s);
    }
}
