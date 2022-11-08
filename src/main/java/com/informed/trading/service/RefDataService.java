package com.informed.trading.service;

import com.informed.trading.dao.CurrencyDao;
import com.informed.trading.dao.EquityDao;
import com.informed.trading.dao.ExchangeDao;
import com.informed.trading.reference.tradedata.Currency;
import com.informed.trading.reference.tradedata.Equity;
import com.informed.trading.reference.tradedata.Exchange;
import com.informed.trading.reference.transactionaldata.EquityTrade;

import java.util.List;

public class RefDataService {

    private CurrencyDao currencyDao;
    private ExchangeDao exchangeDao;
    private EquityDao equityDao;


    public List<Currency> getAllCurrencies() {return currencyDao.getAllCurrencies();
    }
    public List<Exchange> getAllExchanges() {return exchangeDao.getAllExchanges();
    }
    public List<Equity> getAllEquities() {return equityDao.getAllEquities();
    }

    public void addCurrency(Currency currency) {currencyDao.addCurrency(currency);
    }
    public void addExchange(Exchange exchange) {exchangeDao.addExchange(exchange);}
    public void addEquity(Equity equity) {equityDao.addEquity(equity);}

    public boolean deleteCurrencyById(int id) {return currencyDao.deleteCurrencyById(id);
    }

    public boolean deleteEquityById(int id) {return equityDao.deleteEquityById(id);
    }

    public boolean deleteExchangeById(int id) {return exchangeDao.deleteExchangeById(id);
    }
}
