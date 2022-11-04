package com.informed.trading.server;

import com.informed.trading.reference.transactionaldata.EquityTrade;
import com.informed.trading.reference.transactionaldata.UniqueData;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EquityTradeService extends Service {

    public EquityTradeService() {
        super();
    }

    public Optional<EquityTrade> getEquityTradeById(int id) {
        Optional<UniqueData> result = super.getUniqueDataById(id);
        return Optional.of((EquityTrade) result.get());
    }

    public void addEquityTrade(EquityTrade equityTrade) {
        super.add(equityTrade);
    }

    public void addAllEquityTrades(List<EquityTrade> equityTrades) {
        super.addAll(equityTrades);
    }

    public void deleteEquityTrade(EquityTrade equityTrades) {
        super.delete(equityTrades);
    }

    public void deleteEquityTradeById(int id) {
        super.deleteById(id);
    }

    public List<EquityTrade> getAllEquityTrades() {
        return (List<EquityTrade>) super.getAll();
    }
}
