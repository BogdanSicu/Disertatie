package com.munte.disertatiebackend.classes.models.manytomany.compositekeys.favouritefoodskey;

public class FavouriteFoodsKeyBuilder {

    private FavouriteFoodsKey favouriteFoodsKey;

    private long food_id;

    private long user_id;

    public FavouriteFoodsKeyBuilder addFoodId(long food_id) {
        this.food_id = food_id;
        return this;
    }

    public FavouriteFoodsKeyBuilder addUserId(long user_id) {
        this.user_id = user_id;
        return this;
    }

    public FavouriteFoodsKey build() {
        this.favouriteFoodsKey = new FavouriteFoodsKey();
        this.favouriteFoodsKey.setFood_id(this.food_id);
        this.favouriteFoodsKey.setUser_id(this.user_id);
        return this.favouriteFoodsKey;
    }
}
