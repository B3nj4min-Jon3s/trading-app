package com.informed.trading.utils;

import java.util.Currency;

public class Util {
    public static String returnEmptyStringIfNull(String input) {
        if(input == null) {
            return "";
        } else {
            return input;
        }
    }

    public static String getSymbolName(String currencySymbol) {
        return Currency.getInstance(currencySymbol).getDisplayName();
    }
}
