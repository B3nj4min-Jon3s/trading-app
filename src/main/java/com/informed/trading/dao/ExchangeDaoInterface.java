package com.informed.trading.dao;

import com.informed.trading.reference.tradedata.Exchange;

import java.util.List;

public interface ExchangeDaoInterface {
    void addExchange(Exchange exchange);
    List<Exchange> getAllExchanges();
    void deleteExchanges(int id);
}
