package com.informed.trading.samples;

import com.informed.trading.reference.tradedata.TradeDataEntity;

public class SampleTradeDataEntity extends TradeDataEntity {
    public SampleTradeDataEntity() {
    }

    public SampleTradeDataEntity(int id, String name, String symbol) {
        super(id, name, symbol);
    }

    public SampleTradeDataEntity(String name, String symbol) {
        super(name, symbol);
    }
}
