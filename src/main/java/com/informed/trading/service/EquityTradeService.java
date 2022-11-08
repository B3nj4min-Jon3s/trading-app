package com.informed.trading.service;

import com.informed.trading.dao.EquityTradeDao;
import com.informed.trading.reference.transactionaldata.EquityTrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EquityTradeService {

    private EquityTradeDao dao;

    @Autowired
    public void setDao(EquityTradeDao dao) {
        this.dao = dao;
    }

    public List<EquityTrade> getAllEquityTrades() {return dao.getAllEquityTrades();
    }

    public void addEquityTrade(EquityTrade equityTrade) {dao.addEquityTrade(equityTrade);
    }

    public boolean deleteEquityTradeById(int id) {
        return dao.deleteEquityTradeById(id);
    }

    public Optional<EquityTrade> getEquityTradeById(int id) {
        return dao.getEquityTradeById(id);
    }

}