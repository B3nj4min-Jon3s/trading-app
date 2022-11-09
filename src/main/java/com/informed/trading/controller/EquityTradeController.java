package com.informed.trading.controller;


import com.informed.trading.exception.ItemNotFoundException;
import com.informed.trading.reference.tradedata.Currency;
import com.informed.trading.reference.transactionaldata.Address;
import com.informed.trading.reference.transactionaldata.EquityTrade;
import com.informed.trading.service.AddressService;
import com.informed.trading.service.EquityTradeService;
import com.informed.trading.service.RefDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;
import java.util.Optional;

@Component
@RestController
@RequestMapping("trader")
public class EquityTradeController {

    private EquityTradeService equityTradeService;
    private RefDataService refDataService;

    @Autowired
    public void setEquityTradeService(EquityTradeService equityTradeService) {
        this.equityTradeService = equityTradeService;
    }

    @Autowired
    public void setRefDataService(RefDataService refDataService) {
        this.refDataService = refDataService;
    }

    @GetMapping("/trade/list")
    @ResponseStatus(HttpStatus.OK)
    public List<EquityTrade> getEquityTrade() {
        System.out.println("EquityController.getEquityTrade()");
        return equityTradeService.getAllEquityTrades();
    }


    @GetMapping("/trade/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EquityTrade getEquityTrade(@PathVariable int id) {
        System.out.println("EquityTrade.getEquityTrade()");
        Optional<EquityTrade> equityTrade = equityTradeService.getEquityTradeById(id);
        if (equityTrade.isPresent()) {
            return equityTrade.get();
        }
        else {
            throw new ItemNotFoundException("Equity Trade not found with id: " + id);
        }
    }

    @GetMapping("/trade/{id}/value")
    @ResponseStatus(HttpStatus.OK)
    public Double getValueOfEquityTrade(@PathVariable int id) {
        System.out.println("EquityTrade.getEquityTrade()");
        Optional<EquityTrade> equityTrade = equityTradeService.getEquityTradeById(id);
        if (equityTrade.isPresent()) {
            return equityTrade.get().getValueOfTrade();
        }
        else {
            throw new ItemNotFoundException("Equity Trade not found with id: " + id);
        }

    }

    @GetMapping("/trade/{tradeId}/value/{currencyId}")
    @ResponseStatus(HttpStatus.OK)
    public Double getValueOfEquityTradeCurrency(@PathVariable int tradeId, @PathVariable int currencyId) {
        System.out.println("EquityTrade.getEquityTrade()");
        Optional<EquityTrade> equityTrade = equityTradeService.getEquityTradeById(tradeId);
        if (equityTrade.isPresent()) {
            Optional<Currency> currency = refDataService.getCurrencyById(currencyId);
            if (currency.isPresent()) {
                return equityTrade.get().getValueInCurrency(currency.get());
            } else {
                throw new ItemNotFoundException("Currency not found with id: " + currencyId);
            }
        }
        else {
            throw new ItemNotFoundException("Equity Trade not found with id: " + tradeId);
        }

    }


    @PostMapping("/trade")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEquityTrade(@RequestBody EquityTrade equityTrade) {
        System.out.println("EquityTradeController.addEquityTrade(" + equityTrade + ")");
        equityTradeService.addEquityTrade(equityTrade);
    }

    @PostMapping("/trade/value")
    @ResponseStatus(HttpStatus.OK)
    public Double getValueOfPendingEquityTrade(@RequestBody EquityTrade equityTrade) {
        return equityTrade.getValueOfTrade();
    }

    @PutMapping("/trade")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateEquityTrade(@RequestBody EquityTrade equityTrade) {
        System.out.println("EquityTradeController.updateEquityTrade(" + equityTrade + ")");
        equityTradeService.addEquityTrade(equityTrade);
    }

    @DeleteMapping("/trade/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByID(@PathVariable int id) {
        if(!equityTradeService.deleteEquityTradeById(id)){
            throw new ItemNotFoundException("Equity Trade not found with id: " + id);
        }
    }

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(
            value = HttpStatus.NOT_FOUND,
            reason = "Invalid Request")
    public void itemNotFoundFailure() {
        System.out.println("Handling error");
    }

}

