package com.informed.trading.reference.tradedata;

import com.informed.trading.exception.InvalidSymbolArgumentException;
import com.informed.trading.reference.transactionaldata.UniqueData;
import com.informed.trading.utils.Validation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class TradeDataEntity extends UniqueData {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
    @NotNull
    private String name;
    @NotNull
    private String symbol;

    public TradeDataEntity() {
        super();
    }

    public TradeDataEntity(String name, String symbol) {
        super();
        setName(name);
        setSymbol(symbol);

    }

    private void setName(String name) {
        if(Validation.checkStringContainsOnlyLetters(name, "Name") &&
        Validation.checkStringIsEmptyOrNull(name, "Name")) {
            this.name = name;
        }
    }

    private void setSymbol(String symbol) {
        if(symbol.equals("") || !symbol.matches("[a-zA-Z]{1,3}")) {
            throw new InvalidSymbolArgumentException("Please provide a valid symbol i.e. LND");
        } else {
            this.symbol = symbol.toUpperCase();
        }
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
