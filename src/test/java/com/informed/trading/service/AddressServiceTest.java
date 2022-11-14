package com.informed.trading.service;

import com.informed.trading.reference.transactionalData.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = { ServiceTestConfig.class})
class AddressServiceTest{

    @Autowired
    private AddressService service;


    @Test
    void addAddress() {
        Address address = new Address("18 high street", "line", "line", "Manchester", "BANES", "BA2 2EE");
        service.addAddress(address);
        List<Address> addresses = service.getAllAddresses();
        assertThat(addresses)
                .filteredOn(a -> a.getLine1().contains("18 high street") && a.getCity() == "Manchester")
                .hasSize(1);
        System.out.println(addresses);
    }

    @Test
    void getAllAddresses() {
        Address address = new Address("18 low street", "line", "line", "Manchester", "BANES", "BA2 2EE");
        service.addAddress(address);
        System.out.println(address);
        List<Address> addresses = service.getAllAddresses();
        assertThat(addresses.isEmpty()).isFalse();
    }

    @Test
    void getAddressById() {
        Address address = new Address("18 low street", "line", "line", "Manchester", "BANES", "BA2 2EE");
        service.addAddress(address);
        System.out.println(address);
        Address addrDb = service.getAddressById(address.getId()).get();
        assertEquals(address.getLine1(), addrDb.getLine1());
    }


    @Test
    void deleteAddressById() {
        Address address = new Address("18 low street", "line", "line", "Manchester", "BANES", "BA2 2EE");
        service.addAddress(address);
        List<Address> addresses = service.getAllAddresses();
        System.out.println("the address list once the address is added: " + address);
        boolean addrDb = service.deleteAddressById(address.getId());
        assertEquals(true, addrDb);
        addresses = service.getAllAddresses();
        System.out.println(" the address list after the address has been deleted: " + addresses);
    }
}