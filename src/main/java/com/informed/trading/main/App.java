package com.informed.trading.main;

import com.informed.trading.reference.ForeignExchangeRates;

import java.util.UUID;

public class App {
    public static void main(String[] args) {
        ForeignExchangeRates e = new ForeignExchangeRates();
        System.out.println(UUID.randomUUID());
    }
}
