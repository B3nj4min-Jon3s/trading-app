package com.informed.trading.dao;

import com.informed.trading.reference.tradedata.Currency;

import java.util.List;

public interface CurrencyDaoInterface {
    void addCurrency(Currency currency);
    List<Currency> getAllCurrencies();
    void deleteCurrency(int id);
}
