package com.informed.trading.reference.transactionaldata;

import com.informed.trading.exception.EmptyArgumentException;
import com.informed.trading.exception.InvalidArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterPartyTest {
    Address ad1 = new Address("line1", "line", "line", "City", "County", "wa4 2hu");

    @Test
    void shouldThrowEmptyArgumentExceptionForEmptyName() {
        assertThrows(EmptyArgumentException.class, () -> new CounterParty("", "0796548383", "jacey@email.com", ad1));
    }

    @Test
    void shouldThrowNullPointerExceptionForNullName() {
        assertThrows(NullPointerException.class, () -> new CounterParty(null, "0796548383", "jacey@email.com", ad1));
    }

    @Test
    void shouldThrowInvalidArgumentExceptionForSpecialCharactersInName() {
        assertThrows(InvalidArgumentException.class, () -> new CounterParty("name#", "0796548383", "jacey@email.com", ad1));
    }

}