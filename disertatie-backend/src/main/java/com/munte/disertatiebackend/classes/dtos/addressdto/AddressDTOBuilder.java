package com.munte.disertatiebackend.classes.dtos.addressdto;

import com.munte.disertatiebackend.classes.models.addresses.Addresses;
import com.munte.disertatiebackend.classes.models.addresses.AddressesBuilder;

public class AddressDTOBuilder {

    private AddressDTO addressDTO = new AddressDTO();

    private String country;
    private String county;
    private String city;
    private String street;
    private Long streetNumber;
    private String building;
    private String staircase;
    private Long room;

    public AddressDTOBuilder addCountry(String country) {
        addressDTO.setCountry(country);
        return this;
    }

    public AddressDTOBuilder addCounty(String county) {
        addressDTO.setCounty(county);
        return this;
    }

    public AddressDTOBuilder addCity(String city) {
        addressDTO.setCity(city);
        return this;
    }

    public AddressDTOBuilder addStreet(String street) {
        addressDTO.setStreet(street);
        return this;
    }

    public AddressDTOBuilder addStreetNumber(Long streetNumber) {
        addressDTO.setStreetNumber(streetNumber);
        return this;
    }

    public AddressDTOBuilder addBuilding(String building) {
        addressDTO.setBuilding(building);
        return this;
    }

    public AddressDTOBuilder addStaircase(String staircase) {
        addressDTO.setStaircase(staircase);
        return this;
    }

    public AddressDTOBuilder addRoom(Long room) {
        addressDTO.setRoom(room);
        return this;
    }

    public AddressDTO build() {
        return addressDTO;
    }
}

