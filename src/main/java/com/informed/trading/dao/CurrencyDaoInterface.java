package com.informed.trading.dao;

import com.informed.trading.reference.tradedata.Currency;

import javax.transaction.Transactional;
import java.util.List;

public interface CurrencyDaoInterface {
    @Transactional
    void addCurrency(Currency currency);
    List<Currency> getAllCurrencies();
    void deleteCurrency(Currency currency);
}
