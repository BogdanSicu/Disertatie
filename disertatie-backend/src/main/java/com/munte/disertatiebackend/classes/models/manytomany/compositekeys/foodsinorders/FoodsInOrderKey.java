package com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodsinorders;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FoodsInOrderKey implements Serializable {

    @Column(name = "food_id")
    private Long food_id;

    @Column(name = "order_id")
    private Long order_id;

    public Long getFood_id() {
        return food_id;
    }

    public void setFood_id(Long food_id) {
        this.food_id = food_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }
}
