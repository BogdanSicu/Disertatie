package com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodtagskey;

public class FoodTagsKeyBuilder {
    private FoodTagsKey foodTagsKey = new FoodTagsKey();

    private Long food_id;

    private Long tag_id;

    public FoodTagsKeyBuilder addFoodId(Long food_id) {
        this.foodTagsKey.setFood_id(food_id);
        return this;
    }

    public FoodTagsKeyBuilder addTagsId(Long tag_id) {
        this.foodTagsKey.setTag_id(tag_id);
        return this;
    }

    public FoodTagsKey build() {
        return foodTagsKey;
    }
}
