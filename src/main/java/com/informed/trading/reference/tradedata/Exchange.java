package com.informed.trading.reference.tradedata;

import javax.persistence.*;

@Entity
@Table(name = "exchanges")
public class Exchange extends TradeDataEntity {

    public Exchange() {
        super();
    }

    public Exchange(String name, String symbol) {
        super(name, symbol);
    }
}
