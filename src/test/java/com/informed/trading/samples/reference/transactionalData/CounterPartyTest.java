package com.informed.trading.samples.reference.transactionalData;

import com.informed.trading.exception.EmptyArgumentException;
import com.informed.trading.exception.InvalidArgumentException;
import com.informed.trading.reference.transactionalData.Address;
import com.informed.trading.reference.transactionalData.CounterParty;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterPartyTest {
    Address ad1 = new Address("line1", "line", "line", "City", "County", "wa4 2hu");

    @Nested
    public class constructorTest {

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

        @Test
        void shouldThrowNullPointerExceptionForNullAddress() {
            assertThrows(NullPointerException.class, () -> new CounterParty("name", "0796548383", "jacey@email.com", null));
        }

        @Test
        void testEmptyStringIsReturnedIfPhoneIsNull() {
            CounterParty cp1 = new CounterParty("name", null, "jacey@email.com", ad1);
            assertEquals("", cp1.getPhoneNumber());
        }

        @Test
        void testEmptyStringIsReturnedIfEmailIsNull() {
            CounterParty cp2 = new CounterParty("name", "078463836", null, ad1);
            assertEquals("", cp2.getEmailAddress());
        }

        @Test
        void testEmptyArgumentExceptionIsThrownWhenPhoneAndEmailAreBothNull() {
            assertThrows(EmptyArgumentException.class, () -> new CounterParty("name", null, null, ad1));
        }

        @Test
        void testPhoneEqualsPhoneIfPhoneAndEmailNotNuLL() {
            CounterParty cp2 = new CounterParty("name", "078463836", null, ad1);
            assertEquals("078463836", cp2.getPhoneNumber());
        }

        @Test
        void testEmailEqualsEmailIfPhoneAndEmailNotNuLL() {
            CounterParty cp2 = new CounterParty("name", null, "jacey@email.com", ad1);
            assertEquals("jacey@email.com", cp2.getEmailAddress());
        }
    }
}
