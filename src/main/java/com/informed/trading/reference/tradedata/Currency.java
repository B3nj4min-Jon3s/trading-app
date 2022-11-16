package com.informed.trading.reference.tradedata;

import javax.persistence.*;

@Entity
@Table(name = "currencies")
public class Currency extends TradeDataEntity {

    public Currency() {
        super();
    }

    public Currency(String name, String symbol) {
        super(name, symbol);
    }

    public Currency(int id, String name, String symbol) {
        super(id, name, symbol);
    }

}
