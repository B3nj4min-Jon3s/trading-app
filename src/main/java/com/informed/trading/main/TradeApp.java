package com.informed.trading.main;

import com.informed.trading.reference.tradedata.Currency;
import com.informed.trading.reference.tradedata.Equity;
import com.informed.trading.reference.tradedata.Exchange;
import com.informed.trading.reference.transactionaldata.Address;
import com.informed.trading.reference.transactionaldata.CounterParty;
import com.informed.trading.reference.transactionaldata.EquityTrade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

@SpringBootApplication
@ComponentScan("com.informed.trading.config")
public class TradeApp {
    public static void main(String[] args) {
        SpringApplication.run(TradeApp.class, args);

        System.out.println("http://localhost:8282/trader");

        Address a1 = new Address("line1", "line two", "line three", "city", "county", "BL09UG");
        Address a2 = new Address("sfkj", "line two", "line three", "city", "county", "BL09UG");
        CounterParty cp1 = new CounterParty("woop", "07805755934", "g@sd.com", a1);
        CounterParty cp2 = new CounterParty("names", "01204885952", "shdo@ahosf.com", a2);
        Equity e = new Equity("name", "gbh");
        Currency c = new Currency("name", "sdk");
        Exchange ex = new Exchange("name", "hfd");

        EquityTrade equityTrade = new EquityTrade(cp1, cp2, e, 10, 10.2, c, ex);
        System.out.println(equityTrade);
    }
}
