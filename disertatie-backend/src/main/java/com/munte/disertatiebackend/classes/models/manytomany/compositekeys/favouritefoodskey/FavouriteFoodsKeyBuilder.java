package com.munte.disertatiebackend.classes.models.manytomany.compositekeys.favouritefoodskey;

public class FavouriteFoodsKeyBuilder {

    private FavouriteFoodsKey favouriteFoodsKey = new FavouriteFoodsKey();

    private Long food_id;

    private Long user_id;

    public FavouriteFoodsKeyBuilder addFoodId(Long food_id) {
        this.favouriteFoodsKey.setFood_id(food_id);
        return this;
    }

    public FavouriteFoodsKeyBuilder addUserId(Long user_id) {
        this.favouriteFoodsKey.setUser_id(user_id);
        return this;
    }

    public FavouriteFoodsKey build() {
        return this.favouriteFoodsKey;
    }
}
