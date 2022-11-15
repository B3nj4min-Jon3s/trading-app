package com.informed.trading.samples.reference;

import com.informed.trading.exception.EmptyArgumentException;
import com.informed.trading.exception.InvalidArgumentException;
import com.informed.trading.exception.InvalidSymbolArgumentException;
import com.informed.trading.reference.tradedata.TradeDataEntity;
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
    public class Constructor {

        @Nested
        public class SymbolTests {
            @Test
            void shouldThrowSymbolArgumentExceptionWhenSymbolEmptyString() {
                assertThrows(EmptyArgumentException.class, () -> new SampleTradeDataEntity("Manchester", ""));
            }

            @Test
            void shouldThrowNullPointerExceptionWhenSymbolNull() {
                assertThrows(NullPointerException.class, () -> new SampleTradeDataEntity("Manchester", null));
            }

            @Test
            void shouldThrowInvalidArgumentExceptionWhenLongerThanThreeChars() {
                assertThrows(InvalidSymbolArgumentException.class, () -> new SampleTradeDataEntity("Manchester", "HHHH"));
            }

            @Test
            void shouldThrowInvalidArgumentExceptionWithIllegalChars() {
                assertThrows(InvalidSymbolArgumentException.class, () -> new SampleTradeDataEntity("Manchester", "H%H"));
            }

            @Test
            void shouldThrowInvalidArgumentExceptionWithNumbers() {
                assertThrows(InvalidSymbolArgumentException.class, () -> new SampleTradeDataEntity("Manchester", "2GH"));
            }

            @Test
            void shouldSetSymbolToUpperCase() {
                TradeDataEntity testEntity = new SampleTradeDataEntity("Manchester", "man");
                assertEquals("MAN", testEntity.getSymbol());
            }
        }

        @Nested
        public class NameTests {
            @Test
            void shouldThrowNullPointerExceptionWhenNameNull() {
                assertThrows(NullPointerException.class, () -> new SampleTradeDataEntity(null, "MAN"));
            }

            @Test
            void shouldThrowEmptyArgumentExceptionWhenNameEmpty() {
                assertThrows(EmptyArgumentException.class, () -> new SampleTradeDataEntity("", "MAN"));
            }

            @Test
            void shouldThrowInvalidArgumentExceptionWhenNumbers() {
                assertThrows(InvalidArgumentException.class, () -> new SampleTradeDataEntity("M4nchester", "MAN"));
            }

            @Test
            void shouldThrowInvalidArgumentExceptionWhenIllegalChars() {
                assertThrows(InvalidArgumentException.class, () -> new SampleTradeDataEntity("Manchest%er", "MAN"));
            }

            @Test
            void shouldThrowInvalidArgumentExceptionWhenLongerThan50() {
                assertThrows(InvalidArgumentException.class, () -> new SampleTradeDataEntity("Manchesterrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr", "MAN"));
            }

        }
    }
}