package com.informed.trading.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.informed.trading.config")
public class TradeApp {
    public static void main(String[] args) {
        SpringApplication.run(TradeApp.class, args);

        System.out.println("http://localhost:8282/trader");
    }
}
