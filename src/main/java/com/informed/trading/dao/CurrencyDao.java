package com.informed.trading.dao;

import com.informed.trading.reference.tradedata.Currency;
import com.informed.trading.repo.CurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CurrencyDao implements CurrencyDaoInterface{

    @Autowired
    private CurrencyRepo currencyRepo;

    public Optional<Currency> getCurrencyById(int id) {
        return this.currencyRepo.findById(id);
    }

    @Transactional
    public void addCurrency(Currency currency) {
        System.out.println("###########################");
        System.out.println(currency);
        this.currencyRepo.save(currency);
    }

    public List<Currency> getAllCurrencies() {
        Iterable<Currency> searchResults = this.currencyRepo.findAll();
        List<Currency> currencies = new ArrayList<>();
        searchResults.forEach(currencies::add);
        return currencies;
    }
    @Transactional
    public void deleteCurrency(Currency currency) {
        this.currencyRepo.delete(currency);
    }
    @Transactional
    public boolean deleteCurrencyById(int id) {
        if(this.currencyRepo.existsById(id)){
            this.currencyRepo.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
