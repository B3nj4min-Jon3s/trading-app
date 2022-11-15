package com.informed.trading.service;

import com.informed.trading.reference.tradedata.Currency;
import com.informed.trading.reference.tradedata.Equity;
import com.informed.trading.reference.tradedata.Exchange;
import com.informed.trading.reference.transactionalData.Address;
import com.informed.trading.reference.transactionalData.CounterParty;
import com.informed.trading.reference.transactionalData.EquityTrade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@SpringBootTest(classes = { ServiceTestConfig.class})
class EquityTradeServiceTest {

    @Autowired
    private EquityTradeService etService;
    @Autowired
    private CounterPartyService cpService;
    @Autowired
    private AddressService addrService;
    @Autowired
    private RefDataService refService;


    @Test
    void getAllEquityTrades() {
        Address ad1 = new Address("18 low street", "line", "line", "Manchester", "BANES", "BA2 2EE");
        addrService.addAddress(ad1);
        CounterParty cp1 = new CounterParty("jacey", "07947402138", "jacey@email.com", ad1);
        cpService.addCounterParties(cp1);
        CounterParty cp1Db = cpService.getAllCounterParties().get(0);
        CounterParty cp2 = new CounterParty("ag", "0796548383", "ag@email.com", ad1);
        cpService.addCounterParties(cp2);
        CounterParty cp2Db = cpService.getAllCounterParties().get(1);
        Equity equity = new Equity("google", "GOO");
        refService.addEquity(equity);
        Currency currency = new Currency("pounds", "GBP");
        refService.addCurrency(currency);
        Exchange exchange = new Exchange("Ireland", "IRE");
        refService.addExchange(exchange);
        EquityTrade equityTrade = new EquityTrade(cp1Db, cp2Db, refService.getAllEquities().get(0), 10, 20.0, refService.getAllCurrencies().get(0), refService.getAllExchanges().get(0));
        etService.addEquityTrade(equityTrade);
        List<EquityTrade> equityTrades = etService.getAllEquityTrades();
        assertThat(equityTrades.isEmpty()).isFalse();
    }

    @Test
    void addEquityTrade() {
        Address ad1 = new Address("18 low street", "line", "line", "Manchester", "BANES", "BA2 2EE");
        addrService.addAddress(ad1);
        CounterParty cp1 = new CounterParty("jacey", "07947402138", "jacey@email.com", ad1);
        cpService.addCounterParties(cp1);
        CounterParty cp1Db = cpService.getAllCounterParties().get(0);
        CounterParty cp2 = new CounterParty("ag", "0796548383", "ag@email.com", ad1);
        cpService.addCounterParties(cp2);
        CounterParty cp2Db = cpService.getAllCounterParties().get(1);
        Equity equity = new Equity("google", "GOO");
        refService.addEquity(equity);
        Currency currency = new Currency("pounds", "GBP");
        refService.addCurrency(currency);
        Exchange exchange = new Exchange("Ireland", "IRE");
        refService.addExchange(exchange);
        EquityTrade equityTrade = new EquityTrade(cp1Db, cp2Db, refService.getAllEquities().get(0), 17, 25.0, refService.getAllCurrencies().get(0), refService.getAllExchanges().get(0));
        etService.addEquityTrade(equityTrade);
        List<EquityTrade> equityTrades = etService.getAllEquityTrades();
        assertThat(equityTrades)
                .filteredOn(a -> a.getAmount() == 17 && a.getPrice() == 25.0)
                .hasSize(1);
        System.out.println(equityTrades);
    }

    @Test
    void deleteEquityTradeById() {
        Address ad1 = new Address("18 low street", "line", "line", "Manchester", "BANES", "BA2 2EE");
        addrService.addAddress(ad1);
        CounterParty cp1 = new CounterParty("jacey", "07947402138", "jacey@email.com", ad1);
        cpService.addCounterParties(cp1);
        CounterParty cp1Db = cpService.getAllCounterParties().get(0);
        CounterParty cp2 = new CounterParty("ag", "0796548383", "ag@email.com", ad1);
        cpService.addCounterParties(cp2);
        CounterParty cp2Db = cpService.getAllCounterParties().get(1);
        Equity equity = new Equity("google", "GOO");
        refService.addEquity(equity);
        Currency currency = new Currency("pounds", "GBP");
        refService.addCurrency(currency);
        Exchange exchange = new Exchange("Ireland", "IRE");
        refService.addExchange(exchange);
        EquityTrade equityTrade = new EquityTrade(cp1Db, cp2Db, refService.getAllEquities().get(0), 13, 45.0, refService.getAllCurrencies().get(0), refService.getAllExchanges().get(0));
        etService.addEquityTrade(equityTrade);
        List<EquityTrade> equityTrades = etService.getAllEquityTrades();
        System.out.println("the equity trade list once the equity trade is added: " + equityTrade);
        boolean addrDb = etService.deleteEquityTradeById(equityTrade.getId());
        assertEquals(true, addrDb);
        equityTrades = etService.getAllEquityTrades();
        System.out.println(" the equity trade list after the equity trade has been deleted: " + equityTrades);
    }

    @Test
    void getEquityTradeById() {
        Address ad1 = new Address("18 low street", "line", "line", "Manchester", "BANES", "BA2 2EE");
        addrService.addAddress(ad1);
        CounterParty cp1 = new CounterParty("jacey", "07947402138", "jacey@email.com", ad1);
        cpService.addCounterParties(cp1);
        CounterParty cp1Db = cpService.getAllCounterParties().get(0);
        CounterParty cp2 = new CounterParty("ag", "0796548383", "ag@email.com", ad1);
        cpService.addCounterParties(cp2);
        CounterParty cp2Db = cpService.getAllCounterParties().get(1);
        Equity equity = new Equity("google", "GOO");
        refService.addEquity(equity);
        Currency currency = new Currency("pounds", "GBP");
        refService.addCurrency(currency);
        Exchange exchange = new Exchange("Ireland", "IRE");
        refService.addExchange(exchange);
        EquityTrade equityTrade = new EquityTrade(cp1Db, cp2Db, refService.getAllEquities().get(0), 11, 15.0, refService.getAllCurrencies().get(0), refService.getAllExchanges().get(0));
        etService.addEquityTrade(equityTrade);
        EquityTrade etDb = etService.getEquityTradeById(equityTrade.getId()).get();
        assertEquals(equityTrade.getAmount(), etDb.getAmount());
    }
}