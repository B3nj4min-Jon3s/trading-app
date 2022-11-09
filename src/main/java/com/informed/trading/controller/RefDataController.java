package com.informed.trading.controller;

import com.informed.trading.reference.tradedata.Currency;
import com.informed.trading.reference.tradedata.Equity;
import com.informed.trading.reference.tradedata.Exchange;
import com.informed.trading.service.RefDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("trader")
public class RefDataController {

    private RefDataService refDataService;

    @Autowired
    public void setRefDataService(RefDataService refDataService){
        this.refDataService = refDataService;
    }

    @GetMapping("/currencies")
    @ResponseStatus(HttpStatus.OK)
    public List<Currency> getAllCurrencies() {
        System.out.println("CurrencyController.getCurrencies()");
        return refDataService.getAllCurrencies();
    }


    @GetMapping("/equities")
    @ResponseStatus(HttpStatus.OK)
    public List<Equity> getAllEquities() {
        System.out.println("EquityController.getEquities()");
        return refDataService.getAllEquities();
    }

    @GetMapping("/exchanges")
    @ResponseStatus(HttpStatus.OK)
    public List<Exchange> getAllExchanges() {
        System.out.println("ExchangeController.getExchanges()");
        return refDataService.getAllExchanges();
    }
}
