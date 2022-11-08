package com.informed.trading.dao;

import com.informed.trading.reference.transactionaldata.CounterParty;

import java.util.List;
import java.util.Optional;

public interface CounterPartyDaoInterface {
    void addCounterParties(CounterParty counterParties);
    Optional<CounterParty> getCounterPartyById(int id);
    List<CounterParty> getAllCounterParties();
    boolean deleteCounterPartyById(int id);
}
