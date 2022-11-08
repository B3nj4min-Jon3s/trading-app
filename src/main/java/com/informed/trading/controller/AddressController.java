package com.informed.trading.controller;


import com.informed.trading.exception.ItemNotFoundException;
import com.informed.trading.reference.transactionaldata.Address;
import com.informed.trading.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Component
@RestController
@RequestMapping("trader")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Address> getAddresses() {
        System.out.println("AddressController.getAddresses()");
        return addressService.getAllAddresses();
    }


    @GetMapping("/address/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Address getAddress(@PathVariable int id) {
        System.out.println("AddressController.getAddress()");
        Optional<Address> address = addressService.getAddressById(id);
        if (address.isPresent()) {
            return address.get();
        }
        else {
            throw new ItemNotFoundException("address not found with id: " + id);
        }
    }

    @PostMapping("/address")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAddress(@RequestBody Address address) {
        System.out.println("AddressController.addAddress(" + address + ")");
        addressService.addAddress(address);
    }

    @PutMapping("/address")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateAddress(@RequestBody Address address) {
        System.out.println("AddressController.updateAddress(" + address + ")");
        addressService.addAddress(address);
    }

    @DeleteMapping("/address/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByID(@PathVariable int id) {
        if(!addressService.deleteAddressById(id)){
           throw new ItemNotFoundException("address not found with id: " + id);
        }
    }

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(
            value = HttpStatus.NOT_FOUND,
            reason = "Invalid Request")
    public void itemNotFoundFailure() {
        System.out.println("Handling error");
    }

}
