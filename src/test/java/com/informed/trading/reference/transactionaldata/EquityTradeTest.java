//TEST CANNOT BE RUN UNTIL DATABASE OR MOCK DATABASE IS CREATED
//because test runs with checks on ids which are generated by the database and default to 0 (if no database exists)



//package com.informed.trading.reference.transactionaldata;
//
//import com.informed.trading.exception.EmptyArgumentException;
//import com.informed.trading.exception.InvalidArgumentException;
//import com.informed.trading.reference.tradedata.Currency;
//import com.informed.trading.reference.tradedata.Equity;
//import com.informed.trading.reference.tradedata.Exchange;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class EquityTradeTest {
//
//    private Address a1;
//    private CounterParty cp1;
//    private CounterParty cp2;
//    private Equity eq1;
//    private Currency c1;
//    private Exchange ex1;
//    private EquityTrade et1;
//
//    @BeforeEach
//    void setUp() {
//        a1 = new Address("line1", "line two", "line three", "city", "county", "BL09UG");
//        cp1 = new CounterParty("name", "Phoneno", "email", a1);
//        cp2 = new CounterParty("n", "pn", "email", a1);
//        eq1 = new Equity("name", "LND");
//        c1 = new Currency("name", "GBP");
//        ex1 = new Exchange("name", "GBP");
//        et1 = new EquityTrade(cp1, cp2, new Date(), eq1, 12, 2.0, c1, ex1);
//        System.out.println(et1);
//    }
//
//    @Test
//    void setCounterParty2() {
//        assertThrows(InvalidArgumentException.class, () -> new EquityTrade(null, cp2,new Date(), eq1, 12, 1.5, c1, ex1));
//    }
//
//    @Test
//    void setCounterParty1() {
//        assertThrows(InvalidArgumentException.class, () -> new EquityTrade(cp1, null, new Date(), eq1, 12, 1.5, c1, ex1));
//        assertThrows(EmptyArgumentException.class, () -> new EquityTrade(cp1, cp1, new Date(), eq1, 12, 1.2, c1, ex1));
//    }
//
//    @Test
//    void getValueOfTrade() {
//        System.out.println(et1);
//        assertEquals(24, et1.getValueOfTrade(), "the value of this trade should be 24 (derived from 12 x 2)");
//    }
//
//    @Test
//    void getValueInCurrencyTest(){
//
//    }
//
//}