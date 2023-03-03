package com.munte.disertatiebackend.classes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// many users can have the same address
@Entity
@Table(name = "ADDRESSES")
public class Addresses {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "country")
    private String country;
    @Column(name = "county")
    private String county;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "street_number")
    private Long streetNumber;
    @Column(name = "building")
    private String building;
    @Column(name = "room")
    private Long room;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public Long getRoom() {
        return room;
    }

    public void setRoom(Long room) {
        this.room = room;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}
