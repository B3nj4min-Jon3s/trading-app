package com.informed.trading.controller;

import com.informed.trading.reference.tradedata.Currency;
import com.informed.trading.reference.tradedata.Equity;
import com.informed.trading.reference.tradedata.Exchange;
import com.informed.trading.reference.transactionaldata.Address;
import com.informed.trading.service.RefDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("trader")
public class RefDataController {

    private RefDataService refDataService;

    @Autowired
    public void setRefDataService(RefDataService refDataService){
        this.refDataService = refDataService;
    }

    @GetMapping("trader/currencies")
    @ResponseStatus(HttpStatus.OK)
    public List<Currency> getCurrency(@PathVariable int id){
        System.out.println("CurrencyController.getCurrencies()");
        return refDataService.getAllCurrencies();
    }


    @GetMapping("trader/equities")
    @ResponseStatus(HttpStatus.OK)
    public List<Equity> getEquity(@PathVariable int id){
        System.out.println("EquityController.getEquities()");
        return refDataService.getAllEquities();
    }

    @GetMapping("trader/exchanges")
    @ResponseStatus(HttpStatus.OK)
    public List<Exchange> getExchange(@PathVariable int id){
        System.out.println("ExchangeController.getExchanges()");
        return refDataService.getAllExchanges();
    }
}
