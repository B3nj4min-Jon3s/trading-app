package com.informed.trading.server;

import com.informed.trading.reference.transactionaldata.Address;
import com.informed.trading.reference.transactionaldata.UniqueData;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AddressService extends Service {

    public AddressService() {
        super();
    }

    public Optional<Address> getAddressById(int id) {
        Optional<UniqueData> result = super.getUniqueDataById(id);
        return Optional.of((Address) result.get());
    }

    public void addAddress(Address address) {
        super.add(address);
    }

    public void addAllAddresses(List<Address> addresses) {
        super.addAll(addresses);
    }

    public void deleteAddress(Address address) {
        super.delete(address);
    }

    public void deleteAddressById(int id) {
        super.deleteById(id);
    }

    public List<Address> getAllAddresses() {
        return (List<Address>) super.getAll();
    }
}
