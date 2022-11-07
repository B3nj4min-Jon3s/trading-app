package com.informed.trading.reference.transactionaldata;

import com.informed.trading.exception.EmptyArgumentException;
import com.informed.trading.utils.Util;
import com.informed.trading.utils.Validation;

import javax.persistence.*;

@Entity
@Table(name = "counter_parties")
public class CounterParty extends UniqueData {

    private String name;
    private String phoneNumber;
    private String emailAddress;
    @ManyToOne
    @JoinColumn(name = "address_ID")
    private Address address;

    public CounterParty() {
    }

    public CounterParty(String name, String phoneNumber, String emailAddress, Address address) {
        super();
        this.name = Validation.checkStringNotNullEmptyAndOnlyLettersNumbers(name, "Counter party name");
        this.address = address;
        setEmailAddressAndPhone(emailAddress, phoneNumber);
    }

    private void setEmailAddressAndPhone(String email, String phone) {
        String emailNotNull = Util.returnEmptyStringIfNull(email);
        String phoneNotNull = Util.returnEmptyStringIfNull(phone);

        if(emailNotNull.isEmpty() && phoneNotNull.isEmpty()) {
            throw new EmptyArgumentException("A phone number or email must be provided");
        } else {
            this.emailAddress = emailNotNull;
            this.phoneNumber = phoneNotNull;
        }
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Address getAddress() {
        return address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CounterParty{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", address=" + address +
                '}';
    }
}
