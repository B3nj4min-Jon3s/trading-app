package com.informed.trading.reference.transactionaldata;

import com.informed.trading.exception.EmptyArgumentException;
import com.informed.trading.exception.InvalidArgumentException;
import com.informed.trading.exception.InvalidPostcodeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Nested
    public class constructorTest {

        @Test
        void shouldThrowEmptyAddressArgumentExceptionForEmptyLine1() {
            assertThrows(EmptyArgumentException.class, () -> new Address("", "line", "line", "City", "County", "wa4 2hu"));
        }

        @Test
        void shouldThrowNullPointerExceptionForNullLine1() {
            assertThrows(NullPointerException.class, () -> new Address(null, "line", "line", "City", "County", "wa4 2hu"));
        }

        @Test
        void shouldThrowInvalidArgumentExceptionForSpecialCharactersInLine1() {
            assertThrows(InvalidArgumentException.class, () -> new Address("# high street", "line", "line", "City", "County", "wa4 2hu"));
        }

        @Test
        void shouldThrowEmptyAddressArgumentExceptionForEmptyCity() {
            assertThrows(EmptyArgumentException.class, () -> new Address("line1", "line", "line", "", "County", "wa4 2hu"));
        }

        @Test
        void shouldThrowNullPointerExceptionForNullCity() {
            assertThrows(NullPointerException.class, () -> new Address("Line1", "line", "line", null, "County", "wa4 2hu"));
        }

        @Test
        void shouldThrowInvalidArgumentExceptionForNumbersInCity() {
            assertThrows(InvalidArgumentException.class, () -> new Address("line1", "line", "line", "20 manchester", "County", "wa4 2hu"));
        }

        @Test
        void shouldThrowInvalidArgumentExceptionForSpecialCharactersInCity() {
            assertThrows(InvalidArgumentException.class, () -> new Address("line1", "line", "line", "; manchester", "County", "wa4 2hu"));
        }
        @Test
        void shouldThrowEmptyAddressArgumentExceptionForEmptyCounty() {
            assertThrows(EmptyArgumentException.class, () -> new Address("line1", "line", "line", "City", "", "wa4 2hu"));
        }

        @Test
        void shouldThrowNullPointerExceptionForNullCounty() {
            assertThrows(NullPointerException.class, () -> new Address("line1", "line", "line", "City", null, "wa4 2hu"));
        }

        @Test
        void shouldThrowInvalidArgumentExceptionForNumbersInCounty() {
            assertThrows(InvalidArgumentException.class, () -> new Address("line1", "line", "line", "manchester", " 45 County", "wa4 2hu"));
        }

        @Test
        void shouldThrowInvalidArgumentExceptionForSpecialCharactersInCounty() {
            assertThrows(InvalidArgumentException.class, () -> new Address("line1", "line", "line", "manchester", " # County", "wa4 2hu"));
        }
        @Test
        void shouldThrowEmptyAddressArgumentExceptionForEmptyPostcode() {
            assertThrows(EmptyArgumentException.class, () -> new Address("line1", "line", "line", "City", "County", ""));
        }

        @Test
        void shouldThrowNullPointerExceptionForNullPostcode() {
            assertThrows(NullPointerException.class, () -> new Address("line1", "line", "line", "City", "County", null));
        }
        @Test
        void shouldThrowInvalidPostcodeExceptionForInvalidPostcode() {
            assertThrows(InvalidPostcodeException.class, () -> new Address("line1", "line", "line", "City", "County", "hhhh"));
        }

        @Test
        void shouldThrowInvalidPostcodeExceptionForSpecialCharactersInPostcode() {
            assertThrows(InvalidPostcodeException.class, () -> new Address("line1", "line", "line", "City", "County", "ch44 3d*"));
        }

        @Test
        void canHaveEmptyLine2Argument() {
            assertDoesNotThrow(() -> new Address("line1", "", "line", "City", "County", "wa4 2hu"));
        }
        @Test
        void canHaveNullLine2Argument() {
            assertDoesNotThrow(() -> new Address("line1", null, "line", "City", "County", "wa4 2hu"));
        }

        @Test
        void shouldThrowInvalidArgumentExceptionForNumbersInLine2() {
            assertThrows(InvalidArgumentException.class, () -> new Address("line1", " 20 line", "line", "manchester", "County", "wa4 2hu"));
        }

        @Test
        void shouldThrowInvalidArgumentExceptionForSpecialCharactersInLine2() {
            assertThrows(InvalidArgumentException.class, () -> new Address("line1", "@line", "line", "manchester", "County", "wa4 2hu"));
        }

        @Test
        void canHaveEmptyLine3Argument() {
            assertDoesNotThrow(() -> new Address("line1", "line", "", "City", "County", "wa4 2hu"));
        }
        @Test
        void canHaveNullLine3Argument() {
            assertDoesNotThrow(() -> new Address("line1", "line", null, "City", "County", "wa4 2hu"));
        }

        @Test
        void shouldThrowInvalidArgumentExceptionForNumbersInLine3() {
            assertThrows(InvalidArgumentException.class, () -> new Address("line1", "line", "50line", "manchester", "County", "wa4 2hu"));
        }

        @Test
        void shouldThrowInvalidArgumentExceptionForSpecialCharactersInLine3() {
            assertThrows(InvalidArgumentException.class, () -> new Address("line1", "line", "*line", "manchester", "County", "wa4 2hu"));
        }

    }
}