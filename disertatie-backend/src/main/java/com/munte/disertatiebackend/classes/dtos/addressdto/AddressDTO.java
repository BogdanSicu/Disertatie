package com.munte.disertatiebackend.classes.dtos.addressdto;

import com.sun.istack.NotNull;

public class AddressDTO {
    @NotNull
    private String country;
    @NotNull
    private String county;
    @NotNull
    private String city;
    @NotNull
    private String street;
    @NotNull
    private Long streetNumber;
    private String building = null;
    private String staircase = null;
    private Long room = null;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Long streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStaircase() {
        return staircase;
    }

    public void setStaircase(String staircase) {
        this.staircase = staircase;
    }

    public Long getRoom() {
        return room;
    }

    public void setRoom(Long room) {
        this.room = room;
    }
}
