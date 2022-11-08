package com.informed.trading.dao;

import com.informed.trading.reference.tradedata.Equity;
import com.informed.trading.repo.EquityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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

    public void deleteEquity(Equity equity) {
        this.equityRepo.delete(equity);
    }

    public boolean deleteEquityById(int id) {
        if(this.equityRepo.existsById(id)){
            this.equityRepo.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
