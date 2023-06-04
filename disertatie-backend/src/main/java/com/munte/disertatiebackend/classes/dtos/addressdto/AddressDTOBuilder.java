package com.munte.disertatiebackend.classes.dtos.addressdto;

import com.munte.disertatiebackend.classes.models.addresses.Addresses;
import com.munte.disertatiebackend.classes.models.addresses.AddressesBuilder;

public class AddressDTOBuilder {
    private String country;
//    private String county;
    private String city;
    private String street;
    private Long streetNumber;
    private String building;
//    private String staircase;
    private Long room;

    public AddressDTOBuilder addCountry(String country) {
        this.country= country;
        return this;
    }

//    public AddressDTOBuilder addCounty(String county) {
//        addressDTO.setCounty(county);
//        return this;
//    }

    public AddressDTOBuilder addCity(String city) {
        this.city = city;
        return this;
    }

    public AddressDTOBuilder addStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressDTOBuilder addStreetNumber(Long streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public AddressDTOBuilder addBuilding(String building) {
        this.building = building;
        return this;
    }

//    public AddressDTOBuilder addStaircase(String staircase) {
//        addressDTO.setStaircase(staircase);
//        return this;
//    }

    public AddressDTOBuilder addRoom(Long room) {
        this.room = room;
        return this;
    }

    public AddressDTO build() {
        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setCountry(this.country);
        addressDTO.setCity(this.city);
        addressDTO.setStreet(this.street);
        addressDTO.setStreetNumber(this.streetNumber);
        addressDTO.setBuilding(this.building);
        addressDTO.setRoom(this.room);

        return addressDTO;
    }
}

