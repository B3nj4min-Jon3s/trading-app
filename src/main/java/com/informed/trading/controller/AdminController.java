package com.informed.trading.controller;

import com.informed.trading.exception.ItemNotFoundException;
import com.informed.trading.reference.tradedata.Currency;
import com.informed.trading.reference.tradedata.Equity;
import com.informed.trading.reference.tradedata.Exchange;
import com.informed.trading.service.RefDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("admin")
public class AdminController {
    private RefDataService refDataService;

    @Autowired
    public void setRefDataService(RefDataService refDataService){
        this.refDataService = refDataService;
    }

    //CURRENCY
    @PostMapping("/currency")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCurrency(@RequestBody Currency currency) {
        System.out.println("CurrencyController.addCurrency(" + currency + ")");
        refDataService.addCurrency(currency);
    }

    @DeleteMapping("/currency/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCurrencyById(@PathVariable int id){
        if (!refDataService.deleteCurrencyById(id)){
            throw new ItemNotFoundException("Currency not found with id: " + id);
        }
    }

    //EQUITIES
    @PostMapping("/trader/equity")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEquity(@RequestBody Equity equity) {
        System.out.println("EquityController.addEquity(" + equity + ")");
        refDataService.addEquity(equity);
    }

    @DeleteMapping("trader/equity/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEquityById(@PathVariable int id){
        if (!refDataService.deleteEquityById(id)){
            throw new ItemNotFoundException("Equity not found with id: " + id);
        }
    }

    //EXCHANGES
    @PostMapping("/trader/exchange")
    @ResponseStatus(HttpStatus.CREATED)
    public void addExchange(@RequestBody Exchange exchange) {
        System.out.println("ExchangeController.addExchange(" + exchange + ")");
        refDataService.addExchange(exchange);
    }

    @DeleteMapping("trader/exchange/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteExchangesById(@PathVariable int id){
        if (!refDataService.deleteExchangeById(id)){
            throw new ItemNotFoundException("Exchange not found with id: " + id);
        }
    }
}
