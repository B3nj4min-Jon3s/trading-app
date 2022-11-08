package com.informed.trading.dao;

import com.informed.trading.reference.transactionaldata.Address;
import com.informed.trading.reference.transactionaldata.CounterParty;
import com.informed.trading.reference.transactionaldata.UniqueData;

import java.util.List;

public interface AddressDaoInterface {

    void addAddress(Address address);
    List<Address> getAllAddresses();
    boolean deleteAddressById (int id);

}
