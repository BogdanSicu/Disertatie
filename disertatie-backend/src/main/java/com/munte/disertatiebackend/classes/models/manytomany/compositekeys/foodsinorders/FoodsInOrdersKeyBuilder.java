package com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodsinorders;

public class FoodsInOrdersKeyBuilder {

    private FoodsInOrderKey foodsInOrderKey = new FoodsInOrderKey();

    private Long food_id;

    private Long order_id;

    public FoodsInOrdersKeyBuilder addFoodId(Long food_id) {
        this.foodsInOrderKey.setFood_id(food_id);
        return this;
    }

    public FoodsInOrdersKeyBuilder addOrderId(Long order_id) {
        this.foodsInOrderKey.setOrder_id(order_id);
        return this;
    }

    public FoodsInOrderKey build() {
        return this.foodsInOrderKey;
    }

}
