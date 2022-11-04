package com.informed.trading.reference.transactionaldata;

import com.informed.trading.exception.EmptyArgumentException;
import com.informed.trading.exception.InvalidPostcodeException;
import com.informed.trading.utils.Util;
import com.informed.trading.utils.Validation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "addresses")
public class Address extends UniqueData {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
    @NotNull
    private String line1;
    private String line2;
    private String line3;
    @NotNull
    private String city;
    @NotNull
    private String county;
    @NotNull
    private String postcode;

    public Address() {}

    public Address(String line1, String line2, String line3, String city, String county, String postcode) {
        super();
        this.line1 = checkValidAddressLine1(line1, "Address Line 1");
        this.line2 = checkOptionalAddressInput(line2, "Address Line 2");
        this.line3 = checkOptionalAddressInput(line3, "Address Line 3");
        this.city = checkValidAddressInput(city, "City");
        this.county = checkValidAddressInput(county, "County");
        this.postcode = checkValidPostcode(postcode);
    }

    private String checkOptionalAddressInput(String input, String inputName) {
        if (input == null || input.isEmpty()) {
            return Util.returnEmptyStringIfNull(input);
        } else if (Validation.checkStringContainsOnlyLetters(input, inputName)) {
            return input;
        } else {
            return "";
        }
    }

    private String checkValidAddressLine1(String line1, String fieldName) {
        if(Validation.checkStringIsEmptyOrNull(line1, fieldName) &&
                Validation.checkStringContainsOnlyLettersAndNumbers(line1, fieldName)) {
            return line1;
        } else {
            return "";
        }
    }

    private String checkValidAddressInput(String str, String fieldName) {
        if(Validation.checkStringIsEmptyOrNull(str, fieldName) &&
                Validation.checkStringContainsOnlyLetters(str, fieldName)) {
            return str;
        } else {
            return "";
        }
    }

    private String checkValidPostcode(String postcode) {
        if (postcode.isEmpty()) {
            throw new EmptyArgumentException("Please provide information for: Postcode");
        }
        if(postcode.matches("([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9][A-Za-z]?))))\\s?[0-9][A-Za-z]{2})")) {
            return postcode;
        } else {
            throw new InvalidPostcodeException("Please enter a valid postcode");
        }
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getLine3() {
        return line3;
    }

    public String getCity() {
        return city;
    }

    public String getCounty() {
        return county;
    }

    public String getPostcode() {
        return postcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + getId() +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", line3='" + line3 + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
