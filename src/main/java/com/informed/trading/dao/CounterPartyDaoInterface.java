package com.informed.trading.dao;

import com.informed.trading.reference.transactionaldata.CounterParty;

import java.util.List;

public interface CounterPartyDaoInterface {
    void addCounterParties(CounterParty counterParties);
    List<CounterParty> getAllCounterParties();
    void deleteCounterParty(CounterParty counterParty);
}
