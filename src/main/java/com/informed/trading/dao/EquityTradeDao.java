package com.informed.trading.dao;

import com.informed.trading.reference.transactionalData.EquityTrade;
import com.informed.trading.repo.EquityTradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EquityTradeDao implements EquityTradeDaoInterface{

    @Autowired
    private EquityTradeRepo equityTradeRepo;
    @Transactional
    public void addEquityTrade(EquityTrade equityTrade) {
        this.equityTradeRepo.save(equityTrade);
    }

    public List<EquityTrade> getAllEquityTrades() {
        Iterable<EquityTrade> searchResults = this.equityTradeRepo.findAll();
        List<EquityTrade> equityTrades = new ArrayList<>();
        searchResults.forEach(equityTrades::add);
        return equityTrades;
    }

    public Optional<EquityTrade> getEquityTradeById(int id) {
        return this.equityTradeRepo.findById(id);
    }
    @Transactional
    public boolean deleteEquityTradeById(int id) {
        if(this.equityTradeRepo.existsById(id)){
            this.equityTradeRepo.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
