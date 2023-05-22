package com.munte.disertatiebackend.classes.dtos.ordersdto;

public class PizzaOrderDTO {
    private String name;
    private long quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
