package com.informed.trading.utils;

import com.informed.trading.reference.ForeignExchange;
import com.informed.trading.reference.ForeignExchangeRates;
import org.springframework.context.ConfigurableApplicationContext;

public class TraderAppContext {

    private static ConfigurableApplicationContext context;

    public static ConfigurableApplicationContext getApplicationContext() {
        return context;
    }

    public static void setApplicationContext(ConfigurableApplicationContext c) {
        context = c;
    }

    public static ForeignExchangeRates getForeignExchangeRates() {
        return context.getBean(ForeignExchangeRates.class);
    }

}
