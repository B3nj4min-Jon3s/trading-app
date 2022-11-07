package com.informed.trading.dao;

import com.informed.trading.reference.tradedata.Currency;
import com.informed.trading.repo.CurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CurrencyDao implements CurrencyDaoInterface{

    @Autowired
    private CurrencyRepo currencyRepo;

    public void addCurrency(Currency currency) {
        this.currencyRepo.save(currency);
    }

    public List<Currency> getAllCurrencies() {
        Iterable<Currency> searchResults = this.currencyRepo.findAll();
        List<Currency> currencies = new ArrayList<>();
        searchResults.forEach(currencies::add);
        return currencies;
    }


    public void deleteCurrency(int id) {
        this.currencyRepo.deleteById(id);
    }
}
