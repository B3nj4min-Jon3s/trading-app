package com.informed.trading.dao;

import com.informed.trading.reference.tradedata.Equity;

import java.util.List;

public interface EquityDaoInterface {

    void addEquity(Equity equity);
    List<Equity> getAllEquities();
    void deleteEquity(int id);
}
