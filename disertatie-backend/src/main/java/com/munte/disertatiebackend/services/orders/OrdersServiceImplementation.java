package com.munte.disertatiebackend.services.orders;

import com.munte.disertatiebackend.classes.dtos.ordersdto.OrdersDTO;
import com.munte.disertatiebackend.classes.dtos.ordersdto.PizzaOrderDTO;
import com.munte.disertatiebackend.classes.models.orders.Orders;
import com.munte.disertatiebackend.classes.models.addresses.Addresses;
import com.munte.disertatiebackend.classes.models.addresses.AddressesBuilder;
import com.munte.disertatiebackend.classes.models.manytomany.FoodsInOrders;
import com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodsinorders.FoodsInOrdersKeyBuilder;
import com.munte.disertatiebackend.repositories.AddressesRepository;
import com.munte.disertatiebackend.repositories.FoodRepository;
import com.munte.disertatiebackend.repositories.FoodsInOrdersRepository;
import com.munte.disertatiebackend.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImplementation implements OrdersService{

    private final OrdersRepository ordersRepository;
    private final AddressesRepository addressesRepository;
    private final FoodsInOrdersRepository foodsInOrdersRepository;
    private final FoodRepository foodRepository;

    private final JavaMailSender mailSender;

    @Autowired
    public OrdersServiceImplementation(OrdersRepository ordersRepository, AddressesRepository addressesRepository, FoodsInOrdersRepository foodsInOrdersRepository, FoodRepository foodRepository, JavaMailSender mailSender) {
        this.ordersRepository = ordersRepository;
        this.addressesRepository = addressesRepository;
        this.foodsInOrdersRepository = foodsInOrdersRepository;
        this.foodRepository = foodRepository;
        this.mailSender = mailSender;
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public void orderFood(OrdersDTO order) {
        Orders newOrder = new Orders();

        newOrder.setMail(order.getMail());
        newOrder.setPhoneNumber(order.getPhoneNumber());
        newOrder.setUserName(order.getUserName());
        newOrder.setTotalPrice(order.getTotalPrice());

        Addresses newAddress = new AddressesBuilder()
                .addCountry(order.getAddressDTO().getCountry())
                .addCity(order.getAddressDTO().getCity())
                .addStreet(order.getAddressDTO().getStreet())
                .addStreetNumber(order.getAddressDTO().getStreetNumber())
                .addBuilding(order.getAddressDTO().getBuilding())
                .addRoom(order.getAddressDTO().getRoom())
                .build();

        addressesRepository.save(newAddress);

        newOrder.setAddress(newAddress);

        ordersRepository.save(newOrder);

        StringBuilder yes = new StringBuilder();

        for (PizzaOrderDTO pizza : order.getPizzaOrderDTO()) {

            FoodsInOrders newFoodsInOrders = new FoodsInOrders();
            newFoodsInOrders.setId(new FoodsInOrdersKeyBuilder()
                    .addFoodId(foodRepository.findByName(pizza.getName()).getId())
                    .addOrderId(newOrder.getId()).build());

            newFoodsInOrders.setHowMany(pizza.getQuantity());

            yes.append(pizza.getQuantity()).append(" ").append(pizza.getName()).append("\n");

            foodsInOrdersRepository.save(newFoodsInOrders);
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("Yes");
        message.setTo(newOrder.getMail());
        message.setSubject("test");
        message.setText("Comanda ta a fost inregistrata \n "
        + "Comanda contine: \n" + yes);
        mailSender.send(message);

    }

}
