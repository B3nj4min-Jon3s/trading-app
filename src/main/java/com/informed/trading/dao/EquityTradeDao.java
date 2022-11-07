package com.informed.trading.dao;

import com.informed.trading.reference.tradedata.Equity;
import com.informed.trading.reference.transactionaldata.EquityTrade;
import com.informed.trading.repo.EquityTradeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EquityTradeDao implements EquityTradeDaoInterface{

    @Autowired
    private EquityTradeRepo equityTradeRepo;

    public void addEquityTrade(EquityTrade equityTrade) {
        this.equityTradeRepo.save(equityTrade);
    }

    public List<EquityTrade> getAllEquityTrades() {
        Iterable<EquityTrade> searchResults = this.equityTradeRepo.findAll();
        List<EquityTrade> equityTrades = new ArrayList<>();
        searchResults.forEach(equityTrades::add);
        return equityTrades;
    }

    public void deleteEquityTrade(int id) {
        this.equityTradeRepo.deleteById(id);
    }
}
