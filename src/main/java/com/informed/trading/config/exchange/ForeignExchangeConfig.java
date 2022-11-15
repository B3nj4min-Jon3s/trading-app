package com.informed.trading.config.exchange;

import com.informed.trading.reference.ForeignExchangeRates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:foreign-exchange-api.properties")
@ComponentScan(basePackages = {"com.informed.trading.reference"})
public class ForeignExchangeConfig {

    private String EXCHANGE_API_KEY;

    @Value("${api-key}")
    public void setEXCHANGE_API_KEY(String key) {
        this.EXCHANGE_API_KEY = key;
    }

    public String getAPIKey() {
        return this.EXCHANGE_API_KEY;
    }

}
