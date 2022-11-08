package com.informed.trading.dao;

import com.informed.trading.reference.transactionaldata.Address;
import com.informed.trading.reference.transactionaldata.CounterParty;
import com.informed.trading.repo.CounterPartyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CounterPartyDao implements CounterPartyDaoInterface{

    @Autowired
    private CounterPartyRepo counterPartyRepo;

    public void addCounterParties(CounterParty counterParties) {
        this.counterPartyRepo.save(counterParties);
    }

    public List<CounterParty> getAllCounterParties() {
        Iterable<CounterParty> searchResults = this.counterPartyRepo.findAll();
        List<CounterParty> counterParties = new ArrayList<>();
        searchResults.forEach(counterParties::add);
        return counterParties;
    }

    public void deleteCounterParty(CounterParty counterParty) {
        this.counterPartyRepo.delete(counterParty);
    }
}