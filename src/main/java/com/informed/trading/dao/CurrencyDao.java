package com.informed.trading.dao;

import com.informed.trading.reference.tradedata.Currency;
import com.informed.trading.repo.CurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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
    public void deleteCurrency(Currency currency) {
        this.currencyRepo.delete(currency);
    }

    public boolean deleteCurrencyById(int id) {
        if(this.currencyRepo.existsById(id)){
            this.currencyRepo.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
