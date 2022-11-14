package com.informed.trading.dao;

import com.informed.trading.reference.transactionalData.CounterParty;
import com.informed.trading.repo.CounterPartyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CounterPartyDao implements CounterPartyDaoInterface {

    @Autowired
    private CounterPartyRepo counterPartyRepo;

    @Transactional
    public void addCounterParties(CounterParty counterParties) {
        this.counterPartyRepo.save(counterParties);
    }

    public List<CounterParty> getAllCounterParties() {
        Iterable<CounterParty> searchResults = this.counterPartyRepo.findAll();
        List<CounterParty> counterParties = new ArrayList<>();
        searchResults.forEach(counterParties::add);
        return counterParties;
    }

    public Optional<CounterParty> getCounterPartyById(int id) {
        return this.counterPartyRepo.findById(id);
    }

    @Transactional
    public boolean deleteCounterPartyById(int id) {
        if (this.counterPartyRepo.existsById(id)) {
            this.counterPartyRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
