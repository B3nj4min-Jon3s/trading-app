package com.informed.trading.dao;

import com.informed.trading.reference.tradedata.Equity;
import com.informed.trading.repo.EquityRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EquityDao implements EquityDaoInterface{

    @Autowired
    private EquityRepo equityRepo;

    public void addEquity(Equity equity) {
        this.equityRepo.save(equity);
    }

    public List<Equity> getAllEquities() {
        Iterable<Equity> searchResults = this.equityRepo.findAll();
        List<Equity> equities = new ArrayList<>();
        searchResults.forEach(equities::add);
        return equities;
    }

    public void deleteEquity(int id) {
        this.equityRepo.deleteById(id);
    }
}
