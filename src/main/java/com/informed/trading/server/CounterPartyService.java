package com.informed.trading.server;

import com.informed.trading.reference.transactionaldata.CounterParty;
import com.informed.trading.reference.transactionaldata.UniqueData;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CounterPartyService extends Service {

    public CounterPartyService() {
        super();
    }

    public Optional<CounterParty> getCounterPartyById(int id) {
        Optional<UniqueData> result = super.getUniqueDataById(id);
        return Optional.of((CounterParty) result.get());
    }

    public void addCounterParty(CounterParty counterParty) {
        super.add(counterParty);
    }

    public void addAllCounterParties(List<CounterParty> counterParties) {
        super.addAll(counterParties);
    }

    public void deleteCounterParty(CounterParty counterParty) {
        super.delete(counterParty);
    }

    public void deleteCounterPartyById(int id) {
        super.deleteById(id);
    }

    public List<CounterParty> getAllCounterParties() {
        return (List<CounterParty>) super.getAll();
    }
}
