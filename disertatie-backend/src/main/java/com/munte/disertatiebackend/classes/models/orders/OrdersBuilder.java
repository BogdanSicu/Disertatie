package com.munte.disertatiebackend.classes.models.orders;

import com.munte.disertatiebackend.classes.models.addresses.Addresses;

public class OrdersBuilder {
    private String userName;
    private String mail;
    private String phoneNumber;
    private Double totalPrice;
    private Addresses addresses;

    public OrdersBuilder addUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public OrdersBuilder addMail(String mail) {
        this.mail = mail;
        return this;
    }

    public OrdersBuilder addPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public OrdersBuilder addTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public OrdersBuilder addAddress(Addresses addresses) {
        this.addresses = addresses;
        return this;
    }

    public Orders build() {
        Orders orders = new Orders();

        orders.setAddress(this.addresses);
        orders.setTotalPrice(this.totalPrice);
        orders.setPhoneNumber(this.phoneNumber);
        orders.setMail(this.mail);
        orders.setUserName(this.userName);

        return orders;
    }
}
