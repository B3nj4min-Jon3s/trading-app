package com.informed.trading.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.informed.trading.reference", "com.informed.trading.controller"})
public class TradingAppConfig {}
