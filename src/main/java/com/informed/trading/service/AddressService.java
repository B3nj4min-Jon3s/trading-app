package com.informed.trading.service;

import com.informed.trading.dao.AddressDao;
import com.informed.trading.reference.transactionalData.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class AddressService {

    private AddressDao dao;

    @Autowired
    public void setDao(AddressDao dao) {
        this.dao = dao;
    }

    public List<Address> getAllAddresses() {return dao.getAllAddresses();
    }

    public Optional<Address> getAddressById(int id) {return dao.getAddressById(id);}

    public void addAddress(Address address) {dao.addAddress(address);
    }

    public boolean deleteAddressById(int id) {return dao.deleteAddressById(id);}
}