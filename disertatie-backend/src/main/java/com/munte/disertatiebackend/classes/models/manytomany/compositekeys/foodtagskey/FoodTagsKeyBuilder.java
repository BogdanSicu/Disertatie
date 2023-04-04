package com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodtagskey;

public class FoodTagsKeyBuilder {
    private FoodTagsKey foodTagsKey;

    private long food_id;

    private long tag_id;

    public FoodTagsKeyBuilder addFoodId(long food_id) {
        this.food_id = food_id;
        return this;
    }

    public FoodTagsKeyBuilder addTagsId(long tag_id) {
        this.tag_id = tag_id;
        return this;
    }

    public FoodTagsKey build() {
        this.foodTagsKey = new FoodTagsKey();
        this.foodTagsKey.setTag_id(this.tag_id);
        this.foodTagsKey.setFood_id(this.food_id);
        return foodTagsKey;
    }
}
