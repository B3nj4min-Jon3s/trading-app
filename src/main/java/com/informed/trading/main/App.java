package com.informed.trading.main;

import com.informed.trading.reference.ForeignExchangeRates;
import com.informed.trading.reference.transactionaldata.Address;

import java.util.UUID;

public class App {
    public static void main(String[] args) {
       // ForeignExchangeRates e = new ForeignExchangeRates();
        System.out.println(UUID.randomUUID());

        Address addr = new Address("line1", "", null, "tes2t", "test", "wa141hu");
        System.out.println(addr);
    }
}
