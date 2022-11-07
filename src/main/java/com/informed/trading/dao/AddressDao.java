package com.informed.trading.dao;

import com.informed.trading.reference.transactionaldata.Address;
import com.informed.trading.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class AddressDao implements AddressDaoInterface {

    @Autowired
    private AddressRepo addressRepo;

    @Transactional
    public void addAddress(Address address) {
        this.addressRepo.save(address);
    }

    public List<Address> getAllAddresses() {
        Iterable<Address> searchResults = this.addressRepo.findAll();
        List<Address> addresses = new ArrayList<>();
        searchResults.forEach(addresses::add);
        return addresses;
    }

    @Transactional
    public void deleteAddress(int id) {
        this.addressRepo.deleteById(id);
    }
}
