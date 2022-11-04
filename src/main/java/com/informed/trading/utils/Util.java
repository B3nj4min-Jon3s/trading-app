package com.informed.trading.utils;

public class Util {
    public static String returnEmptyStringIfNull(String input) {
        if(input == null) {
            return "";
        } else {
            return input;
        }
    }
}
