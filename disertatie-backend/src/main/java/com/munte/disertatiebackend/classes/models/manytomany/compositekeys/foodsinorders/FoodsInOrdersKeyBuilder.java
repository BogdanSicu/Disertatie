package com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodsinorders;

public class FoodsInOrdersKeyBuilder {

    private FoodsInOrderKey foodsInOrderKey;

    private long food_id;

    private long order_id;

    public FoodsInOrdersKeyBuilder addFoodId(long food_id) {
        this.food_id = food_id;
        return this;
    }

    public FoodsInOrdersKeyBuilder addOrderId(long order_id) {
        this.order_id = order_id;
        return this;
    }

    public FoodsInOrderKey build() {
        this.foodsInOrderKey = new FoodsInOrderKey();
        this.foodsInOrderKey.setOrder_id(this.order_id);
        this.foodsInOrderKey.setFood_id(this.food_id);
        return this.foodsInOrderKey;
    }

}
