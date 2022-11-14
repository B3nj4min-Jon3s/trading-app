package com.informed.trading.dao;

import com.informed.trading.reference.transactionalData.EquityTrade;

import java.util.List;
import java.util.Optional;

public interface EquityTradeDaoInterface {
    void addEquityTrade(EquityTrade equityTrade);
    List<EquityTrade> getAllEquityTrades();
    Optional<EquityTrade> getEquityTradeById(int id);
    boolean deleteEquityTradeById(int id);
}
