package com.munte.disertatiebackend.controllers;

import com.munte.disertatiebackend.classes.dtos.ordersdto.OrdersDTO;
import com.munte.disertatiebackend.classes.models.Orders;
import com.munte.disertatiebackend.services.orders.OrdersService;
import com.munte.disertatiebackend.services.orders.OrdersServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/orders/")
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersServiceImplementation ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("get-all-orders")
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @PostMapping("order-food")
    public void orderFood(@RequestBody OrdersDTO order) {
        this.ordersService.orderFood(order);
    }
}
