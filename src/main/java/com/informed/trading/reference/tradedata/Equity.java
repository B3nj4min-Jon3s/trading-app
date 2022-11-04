package com.informed.trading.reference.tradedata;

import javax.persistence.*;


@Entity
@Table(name = "equities")
public class Equity extends TradeDataEntity {

    public Equity() {
        super();
    }

    public Equity(String name, String symbol) {
        super(name, symbol);
    }
}
