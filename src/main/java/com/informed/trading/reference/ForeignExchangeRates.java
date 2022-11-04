package com.informed.trading.reference;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.informed.trading.interfaces.ForeignExchange;
import com.informed.trading.reference.transactionaldata.UniqueData;

import javax.persistence.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ForeignExchangeRates extends UniqueData implements ForeignExchange {

    private int id;
    private static final String EXCHANGE_API_KEY = "0b25bd30f390d77d5b4c3745";
    private static final String URL_STR = "https://v6.exchangerate-api.com/v6/"+EXCHANGE_API_KEY+"/latest/";
    private static final String[] CURRENCY_ARRAY = {"GBP", "USD", "EUR", "YEN", "AUD"};
    private static final String GBP_STR = "GBP";
    private JsonObject gbpExchangeRates;

    public ForeignExchangeRates() {
        setup();
    }

    private void setup() {
        gbpExchangeRates = getCurrentExchangeRatesForCurrency("GBP");
        System.out.println(gbpExchangeRates.get("USD"));
    }

    private JsonObject getCurrentExchangeRatesForCurrency(String currency) {
        try {
            // Making Request
            URL url = new URL(createApiUrlForCurrency(currency));
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            // Accessing object
            return jsonobj.getAsJsonObject("conversion_rates");
        } catch (Exception e) {
            e.printStackTrace();
            //TODO PROPER ERROR HANDLING
        }
        return new JsonObject();
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
}
