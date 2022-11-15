package com.informed.trading.dao;

import com.informed.trading.reference.transactionalData.Address;

import java.util.List;
import java.util.Optional;

public interface AddressDaoInterface {

    void addAddress(Address address);
    Optional<Address> getAddressById(int id);
    List<Address> getAllAddresses();
    boolean deleteAddressById (int id);

}
