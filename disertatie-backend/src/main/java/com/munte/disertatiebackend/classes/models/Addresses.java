package com.munte.disertatiebackend.classes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @Column(name = "staircase")
    private String staircase;
    @Column(name = "room")
    private Long room;
    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private Set<Users> users = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private Set<Orders> orders = new HashSet<>();

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

    public String getStaircase() {
        return staircase;
    }

    public void setStaircase(String staircase) {
        this.staircase = staircase;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
