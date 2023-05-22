package com.munte.disertatiebackend.classes.dtos.ordersdto;

import com.munte.disertatiebackend.classes.dtos.addressdto.AddressDTO;

import java.util.List;

public class OrdersDTO {
    private String userName;
    private String mail;
    private String phoneNumber;
    private AddressDTO addressDTO;
    private List<PizzaOrderDTO> pizzaOrderDTO;
    private Double totalPrice;

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public List<PizzaOrderDTO> getPizzaOrderDTO() {
        return pizzaOrderDTO;
    }

    public void setPizzaOrderDTO(List<PizzaOrderDTO> pizzaOrderDTO) {
        this.pizzaOrderDTO = pizzaOrderDTO;
    }
}
