package com.munte.disertatiebackend.services.orders;

import com.munte.disertatiebackend.classes.dtos.ordersdto.OrdersDTO;
import com.munte.disertatiebackend.classes.models.orders.Orders;

import java.util.List;

public interface OrdersService {
    public List<Orders> getAllOrders();
    public void orderFood(OrdersDTO order);
}
