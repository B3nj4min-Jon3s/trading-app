package com.informed.trading.dao;

import com.informed.trading.reference.transactionalData.Address;
import com.informed.trading.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
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

    public Optional<Address> getAddressById(int id) {
        return this.addressRepo.findById(id);
    }


    @Transactional
    public boolean deleteAddressById(int id) {
        if (this.addressRepo.existsById(id)) {
            this.addressRepo.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
