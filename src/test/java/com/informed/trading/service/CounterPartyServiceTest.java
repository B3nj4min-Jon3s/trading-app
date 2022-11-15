package com.informed.trading.service;

import com.informed.trading.reference.transactionalData.Address;
import com.informed.trading.reference.transactionalData.CounterParty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = { ServiceTestConfig.class })
class CounterPartyServiceTest {

    @Autowired
    private CounterPartyService service;
    @Autowired
    private AddressService addressService;

    @Test
    void getAllCounterParties() {
        Address ad1 = new Address("line1", "line", "line", "City", "County", "wa4 2hu");
        addressService.addAddress(ad1);
        CounterParty counterParty = new CounterParty("jacey", "0796548383", "jacey@email.com", addressService.getAllAddresses().get(0));
        service.addCounterParties(counterParty);
        System.out.println(counterParty);
        List<CounterParty> counterParties = service.getAllCounterParties();
        assertThat(counterParties.isEmpty()).isFalse();
    }

    @Test
    void getCounterPartyById() {
        Address ad1 = new Address("line1", "line", "line", "City", "County", "wa4 2hu");
        addressService.addAddress(ad1);
        CounterParty counterParty = new CounterParty("ag", "0796548383", "jacey@email.com", addressService.getAllAddresses().get(0));
        service.addCounterParties(counterParty);
        CounterParty addrDb = service.getCounterPartyById(counterParty.getId()).get();
        assertEquals(counterParty.getName(), addrDb.getName());
    }
    @Test
    void addCounterParties() {
        Address ad1 = new Address("line1", "line", "line", "City", "County", "wa4 2hu");
        addressService.addAddress(ad1);
        CounterParty counterParty = new CounterParty("ben", "077556473", "jacey@email.com", addressService.getAllAddresses().get(0));
        service.addCounterParties(counterParty);
        List<CounterParty> counterParties = service.getAllCounterParties();
        assertThat(counterParties)
                .filteredOn(a -> a.getName().contains("ben") && a.getPhoneNumber() == "077556473")
                .hasSize(1);
        System.out.println(counterParties);
    }

    @Test
    void deleteCounterPartyById() {
        Address ad1 = new Address("line1", "line", "line", "City", "County", "wa4 2hu");
        addressService.addAddress(ad1);
        CounterParty counterParty = new CounterParty("bob", "0796548383", "jacey@email.com", addressService.getAllAddresses().get(0));
        service.addCounterParties(counterParty);
        List<CounterParty> counterParties = service.getAllCounterParties();
        System.out.println("the counter party list once the counter party is added: " + counterParties);
        boolean cpDb = service.deleteCounterPartyById(counterParty.getId());
        assertEquals(true, cpDb);
        counterParties = service.getAllCounterParties();
        System.out.println(" the counter party list after the counter party has been deleted: " + counterParties);
    }
}
