package com.informed.trading.dao;

import com.informed.trading.reference.transactionaldata.EquityTrade;

import java.util.List;

public interface EquityTradeDaoInterface {
    void addEquityTrade(EquityTrade equityTrade);
    List<EquityTrade> getAllEquityTrades();
    void deleteEquityTrade(int id);
}
