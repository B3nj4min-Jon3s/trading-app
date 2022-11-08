package com.informed.trading.reference;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.informed.trading.config.ForeignExchangeConfig;
import com.informed.trading.interfaces.ForeignExchange;
import com.informed.trading.reference.tradedata.Currency;
import com.informed.trading.reference.transactionaldata.UniqueData;
import com.informed.trading.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class ForeignExchangeRates implements ForeignExchange {

    private final String EXCHANGE_API_KEY ;
    private ForeignExchangeConfig fec;

    private final  String URL_STR;
    private static final String GBP_STR = "GBP";
    private JsonObject gbpExchangeRates;

    @Autowired
    public ForeignExchangeRates(ForeignExchangeConfig fec) {
        EXCHANGE_API_KEY = fec.getAPIKey();
        this.fec = fec;

        URL_STR = "https://v6.exchangerate-api.com/v6/"+EXCHANGE_API_KEY+"/latest/";
        setup();
    }

    private void setup() {
        gbpExchangeRates = getCurrentExchangeRatesForCurrency("GBP");
    }

    private JsonObject getCurrentExchangeRatesForCurrency(String currency) {
        JsonObject jsonObject = new JsonObject();
        try {
            // Making Request
            URL url = new URL(createApiUrlForCurrency(currency));
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonObject jsonObjectRequest = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()))
                    .getAsJsonObject();

            // Accessing object
            jsonObject = jsonObjectRequest.getAsJsonObject("conversion_rates");
        } catch (Exception e) {
            System.out.println("Error connecting to Exchange Rate API");
            e.printStackTrace();
        }
        return jsonObject;
    }

    private String createApiUrlForCurrency(String currency) {
        return URL_STR+currency;
    }

    private double getGbpExchangeRate(String currency) {
        return gbpExchangeRates.get(currency).getAsDouble();
    }

    public double getExchangeRateFor(String currency1, String currency2) {
        if(currency1.equals(GBP_STR)) {
            return getGbpExchangeRate(currency2);
        } else {
            return getGbpExchangeRate(currency2)/getGbpExchangeRate(currency1);
        }
    }

    public Set<String> getAllSymbolsAsSet() {
        return gbpExchangeRates.asMap().keySet();
    }
    
    public void testAddAllCurrenciesToDb(Set<String> symbols) {
        symbols.forEach(s -> new Currency(Util.getSymbolName(s), s));
    }
}
