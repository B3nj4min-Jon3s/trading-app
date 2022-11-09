package com.informed.trading.service;

import com.informed.trading.dao.CurrencyDao;
import com.informed.trading.dao.EquityDao;
import com.informed.trading.dao.EquityTradeDao;
import com.informed.trading.dao.ExchangeDao;
import com.informed.trading.reference.tradedata.Currency;
import com.informed.trading.reference.tradedata.Equity;
import com.informed.trading.reference.tradedata.Exchange;
import com.informed.trading.reference.transactionaldata.EquityTrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RefDataService {

    private CurrencyDao currencyDao;
    private ExchangeDao exchangeDao;
    private EquityDao equityDao;

    @Autowired
    public void setCurrencyDao(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    @Autowired
    public void setExchangeDao(ExchangeDao exchangeDao) {
        this.exchangeDao = exchangeDao;
    }

    @Autowired
    public void setDao(EquityDao equityDao) {
        this.equityDao = equityDao;
    }

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
