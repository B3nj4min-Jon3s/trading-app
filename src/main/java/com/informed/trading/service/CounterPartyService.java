package com.informed.trading.service;

import com.informed.trading.dao.CounterPartyDao;
import com.informed.trading.reference.transactionaldata.CounterParty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CounterPartyService {

    private CounterPartyDao dao;

    @Autowired
    public void setDao(CounterPartyDao dao) {
        this.dao = dao;
    }

    public List<CounterParty> getAllCounterParties() {return dao.getAllCounterParties();
    }

    public void addCounterParties (CounterParty counterParty) {dao.addCounterParties(counterParty);
    }

    public void deleteCounterParty (CounterParty counterParty) {dao.deleteCounterParty(counterParty);}
}
