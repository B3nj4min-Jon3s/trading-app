package com.informed.trading.reference;

import com.informed.trading.exception.InvalidSymbolArgumentException;
import com.informed.trading.samples.SampleTradeDataEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TradeDataEntityTest {

    SampleTradeDataEntity sampleTadeEntity;

    @BeforeEach
    void setUp() {
        sampleTadeEntity = new SampleTradeDataEntity("Manchester", "MAN");
    }

    @AfterEach
    void tearDown() {
        sampleTadeEntity = null;
    }

    @Nested
    public class constructorTests {

        @Test
        void shouldGenerateRandomIdWhenNotSupplied() {
            sampleTadeEntity = new SampleTradeDataEntity("Manchester", "MAN");
            assertNotEquals(0, sampleTadeEntity.getId());
        }

        @Test
        void shouldThrowSymbolArgumentExceptionWhenSymbolEmptyString() {
            assertThrows(InvalidSymbolArgumentException.class, () -> new SampleTradeDataEntity("Manchester", ""));
        }

        @Test
        void shouldThrowNullPointerExceptionWhenSymbolNull() {
            assertThrows(NullPointerException.class, () -> new SampleTradeDataEntity("Manchester", null));
        }
    }
}