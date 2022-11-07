package com.informed.trading.reference.transactionaldata;

import com.informed.trading.exception.EmptyArgumentException;
import com.informed.trading.exception.InvalidArgumentException;
import com.informed.trading.reference.tradedata.Currency;
import com.informed.trading.reference.tradedata.Equity;
import com.informed.trading.reference.ForeignExchangeRates;
import com.informed.trading.reference.tradedata.Exchange;
import com.informed.trading.utils.Validation;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "equity_trades")
public class EquityTrade extends UniqueData {

    @ManyToOne
    @JoinColumn(name = "exchange_id")
    private Exchange exchange;
    @ManyToOne
    @JoinColumn(name = "counter_party_1_ID")
    private CounterParty counterParty1;
    @ManyToOne
    @JoinColumn(name = "counter_party_2_ID")
    private CounterParty counterParty2;
    private Date agreementDate;
    @OneToOne
    @JoinColumn(name = "equity_ID")
    private Equity equity;
    private int amount;
    private double price;
    @OneToOne
    @JoinColumn(name = "currency_ID")
    private Currency currency;

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    public EquityTrade() {}

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setEquity(Equity equity) {
        this.equity = equity;
    }

    public void setCounterParty2(CounterParty counterParty2) {
        this.counterParty2 = counterParty2;
    }

    public void setCounterParty1(CounterParty counterParty1) {
        this.counterParty1 = counterParty1;
    }

    public EquityTrade(CounterParty counterParty1, CounterParty counterParty2, Date agreementDate, Equity equity, int amount, double price, Currency currency, Exchange exchange) {
        super();
        this.exchange = (Exchange) Validation.checkObjectIsNotNullAndReturnObject(exchange, "exchange");
        this.agreementDate = (Date) Validation.checkObjectIsNotNullAndReturnObject(agreementDate, "Agreement Date");
        this.equity =  (Equity) Validation.checkObjectIsNotNullAndReturnObject(equity, "Equity");
        this.amount = Validation.checkIntIsGreaterThanZero(amount, "Amount");
        this.price = Validation.checkDoubleIsGreaterThanZero(price, "Price");
        this.currency = currency;
        setCounterParties(counterParty1, counterParty2);
    }

    private void setCounterParties(CounterParty counterParty1, CounterParty counterParty2) {
        if (Validation.checkObjectIsNotNull(counterParty1, "Counter Party 1") ||
                Validation.checkObjectIsNotNull(counterParty2, "Counter Party 2")) {
            if(counterParty1.getId() == counterParty2.getId()) {
                throw new InvalidArgumentException("Counter Party 1 & 2 cannot be the same");
            } else {
                this.counterParty1 = counterParty1;
                this.counterParty2 = counterParty2;
            }
        } else {
            throw new EmptyArgumentException("Please provide both Counter Party 1 & Counter Party 2");
        }
    }

    public double getValueOfTrade() {
        return this.amount * this.price;
    }

    public double getValueInCurrency(Currency currency) {
        ForeignExchangeRates fe = new ForeignExchangeRates();
        double exchangeRate = fe.getExchangeRateFor(this.currency.getSymbol(), currency.getSymbol());
        return exchangeRate * getValueOfTrade();
    }

    public void setAgreementDate(Date agreementDate) {
        this.agreementDate = agreementDate;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CounterParty getCounterParty1() {
        return counterParty1;
    }

    public CounterParty getCounterParty2() {
        return counterParty2;
    }

    public Date getAgreementDate() {
        return agreementDate;
    }

    public Equity getEquity() {
        return equity;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "EquityTrade{" +
                "id='" + getId() + '\'' +
                "counterParty1=" + counterParty1 +
                ", counterParty2=" + counterParty2 +
                ", agreementDate=" + agreementDate +
                ", equity=" + equity +
                ", amount=" + amount +
                ", price=" + price +
                ", currency=" + currency +
                '}';
    }
}
