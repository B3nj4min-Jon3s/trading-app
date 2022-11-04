package com.informed.trading.reference.transactionaldata;

import com.informed.trading.exception.EmptyArgumentException;
import com.informed.trading.exception.InvalidPostcodeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldThrowEmptyAddressArgumentExceptionForEmptyLine1() {
        assertThrows(EmptyArgumentException.class, () -> new Address("", "line2", "line3", "City", "County", "wa4 2hu"));
    }

    @Test
    void shouldThrowEmptyAddressArgumentExceptionForEmptyCity() {
        assertThrows(EmptyArgumentException.class, () -> new Address("line1", "line2", "line3", "", "County", "wa4 2hu"));
    }

    @Test
    void shouldThrowEmptyAddressArgumentExceptionForEmptyCounty() {
        assertThrows(EmptyArgumentException.class, () -> new Address("line1", "line2", "line3", "City", "", "wa4 2hu"));
    }

    @Test
    void shouldThrowEmptyAddressArgumentExceptionForEmptyPostcode() {
        assertThrows(EmptyArgumentException.class, () -> new Address("line1", "line2", "line3", "City", "County", ""));
    }

    @Test
    void shouldThrowInvalidPostcodeExceptionForEmptyPostcode() {
        assertThrows(InvalidPostcodeException.class, () -> new Address("line1", "line2", "line3", "City", "County", "hhhh"));
    }

    @Test
    void canHaveEmptyLine2Argument() {
        assertDoesNotThrow(() -> new Address("line1", "", "line3", "City", "County", "wa4 2hu"));
    }

    @Test
    void canHaveEmptyLine3Argument() {
        assertDoesNotThrow(() -> new Address("line1", "line2", "", "City", "County", "wa4 2hu"));
    }


}