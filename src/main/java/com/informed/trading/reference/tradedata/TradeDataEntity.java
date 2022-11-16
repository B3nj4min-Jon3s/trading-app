package com.informed.trading.reference.tradedata;

import com.informed.trading.exception.InvalidSymbolArgumentException;
import com.informed.trading.reference.transactionalData.UniqueData;
import com.informed.trading.utils.Validation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class TradeDataEntity extends UniqueData {
    @NotNull
    private String name;
    @NotNull
    private String symbol;

    public TradeDataEntity() {
        super();
    }

    public TradeDataEntity(String name, String symbol) {
        super();
        this.name = Validation.checkStringNotNullEmptyAndOnlyLetters(name, "Name");
        setSymbol(symbol);

    }

    private void setSymbol(String symbol) {
        Validation.checkStringIsNullOrEmpty(symbol, "Symbol");
        if(!symbol.matches("[a-zA-Z]{1,3}")) {
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
