package com.munte.disertatiebackend.classes.models.manytomany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.munte.disertatiebackend.classes.models.foods.Food;
import com.munte.disertatiebackend.classes.models.orders.Orders;
import com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodsinorders.FoodsInOrderKey;

import javax.persistence.*;

@Entity
@Table(name = "FOOD_IN_ORDERS")
public class FoodsInOrders {

    @JsonIgnore
    @EmbeddedId
    FoodsInOrderKey id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "food_id")
    private Food food;

    @JsonIgnore
    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "order_id")
    private Orders order;

    @Column(name = "how_many")
    private Long howMany;

    public FoodsInOrderKey getId() {
        return id;
    }

    public void setId(FoodsInOrderKey id) {
        this.id = id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Long getHowMany() {
        return howMany;
    }

    public void setHowMany(Long howMany) {
        this.howMany = howMany;
    }
}
