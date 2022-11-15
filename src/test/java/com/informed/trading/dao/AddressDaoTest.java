package com.informed.trading.dao;

import com.informed.trading.reference.transactionalData.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = { DaoTestConfig.class})
class AddressDaoTest {

    @Autowired
    private AddressDao addressDao;


    @Test
    void addAddress() {
        Address address = new Address("18 high street", "line", "line", "Manchester", "BANES", "BA2 2EE");
        addressDao.addAddress(address);
        List<Address> addresses = addressDao.getAllAddresses();
        assertThat(addresses)
                .filteredOn(a -> a.getLine1().contains("18 high street") && a.getCity() == "Manchester")
                .hasSize(1);
        System.out.println(addresses);
    }

    @Test
    void getAllAddresses() {
        Address address = new Address("18 low street", "line", "line", "Manchester", "BANES", "BA2 2EE");
        addressDao.addAddress(address);
        System.out.println(address);
        List<Address> addresses = addressDao.getAllAddresses();
        assertThat(addresses.isEmpty()).isFalse();
    }

    @Test
    void getAddressById() {
        Address address = new Address("18 low street", "line", "line", "Manchester", "BANES", "BA2 2EE");
        addressDao.addAddress(address);
        System.out.println(address);
        Address addrDb = addressDao.getAddressById(address.getId()).get();
        assertEquals(address.getLine1(), addrDb.getLine1());
    }


    @Test
    void deleteAddressById() {
        Address address = new Address("18 low street", "line", "line", "Manchester", "BANES", "BA2 2EE");
        addressDao.addAddress(address);
        List<Address> addresses = addressDao.getAllAddresses();
        System.out.println("the address list once the address is added: " + address);
        boolean addrDb = addressDao.deleteAddressById(address.getId());
        assertEquals(true, addrDb);
        addresses = addressDao.getAllAddresses();
        System.out.println(" the address list after the address has been deleted: " + addresses);
    }
}