package com.informed.trading.main;

import com.informed.trading.reference.tradedata.Currency;
import com.informed.trading.reference.tradedata.Equity;
import com.informed.trading.reference.tradedata.Exchange;
import com.informed.trading.reference.transactionaldata.Address;
import com.informed.trading.reference.transactionaldata.CounterParty;
import com.informed.trading.reference.transactionaldata.EquityTrade;
import com.informed.trading.utils.TraderAppContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

@SpringBootApplication
@ComponentScan("com.informed.trading.config")
public class TradeApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TradeApp.class, args);
        TraderAppContext.setApplicationContext(context);


        System.out.println("http://localhost:8282/trader");
    }
}
