package com.informed.trading.exception;

public class InvalidSymbolArgumentException extends IllegalArgumentException {
    public InvalidSymbolArgumentException(String s) {
        super(s);
    }
}
