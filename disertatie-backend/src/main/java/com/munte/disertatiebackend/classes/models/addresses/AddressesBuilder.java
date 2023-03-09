package com.munte.disertatiebackend.classes.models.addresses;

import javax.persistence.Column;

public class AddressesBuilder {

    private Addresses address = new Addresses();

    private String country;
    private String county;
    private String city;
    private String street;
    private Long streetNumber;
    private String building;
    private String staircase;
    private Long room;

    public AddressesBuilder addCountry(String country) {
        address.setCountry(country);
        return this;
    }

    public AddressesBuilder addCounty(String county) {
        address.setCounty(county);
        return this;
    }

    public AddressesBuilder addCity(String city) {
        address.setCity(city);
        return this;
    }

    public AddressesBuilder addStreet(String street) {
        address.setStreet(street);
        return this;
    }

    public AddressesBuilder addStreetNumber(Long streetNumber) {
        address.setStreetNumber(streetNumber);
        return this;
    }

    public AddressesBuilder addBuilding(String building) {
        address.setBuilding(building);
        return this;
    }

    public AddressesBuilder addStaircase(String staircase) {
        address.setStaircase(staircase);
        return this;
    }

    public AddressesBuilder addRoom(Long room) {
        address.setRoom(room);
        return this;
    }

    public Addresses build() {
        return address;
    }

}
