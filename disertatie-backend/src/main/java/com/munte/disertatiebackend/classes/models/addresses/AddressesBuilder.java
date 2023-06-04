package com.munte.disertatiebackend.classes.models.addresses;

import javax.persistence.Column;

public class AddressesBuilder {

    private String country;
//    private String county;
    private String city;
    private String street;
    private long streetNumber;
    private String building;
//    private String staircase;
    private long room;

    public AddressesBuilder addCountry(String country) {
        this.country = country;
        return this;
    }

//    public AddressesBuilder addCounty(String county) {
//        this.county = county;
//        return this;
//    }

    public AddressesBuilder addCity(String city) {
        this.city = city;
        return this;
    }

    public AddressesBuilder addStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressesBuilder addStreetNumber(long streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public AddressesBuilder addBuilding(String building) {
        this.building = building;
        return this;
    }

//    public AddressesBuilder addStaircase(String staircase) {
//        this.staircase = staircase;
//        return this;
//    }

    public AddressesBuilder addRoom(long room) {
        this.room = room;
        return this;
    }

    public Addresses build() {
        Addresses address = new Addresses();
        address.setCountry(this.country);
//        this.address.setCounty(this.county);
        address.setCity(this.city);
        address.setStreet(this.street);
        address.setStreetNumber(this.streetNumber);
        address.setBuilding(this.building);
//        this.address.setStaircase(this.staircase);
        address.setRoom(this.room);
        return address;
    }

}
