package com.informed.trading.reference;

import com.informed.trading.reference.tradedata.Currency;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class CurrenciesTest {

    Currency currency;

    @BeforeEach
    void setUp() {
        currency = new Currency("London", "LDN");
    }

    @AfterEach
    void tearDown() {
        currency = null;
    }


}