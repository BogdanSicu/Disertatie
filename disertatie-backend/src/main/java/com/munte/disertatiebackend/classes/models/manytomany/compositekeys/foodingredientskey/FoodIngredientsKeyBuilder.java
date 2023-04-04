package com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodingredientskey;

public class FoodIngredientsKeyBuilder {

    private FoodIngredientsKey foodIngredientsKey;

    private long food_id;

    private long ingredient_id;

    public FoodIngredientsKeyBuilder addFoodId(long food_id) {
        this.food_id = food_id;
        return this;
    }

    public FoodIngredientsKeyBuilder addIngredientId(long ingredient_id) {
        this.ingredient_id = ingredient_id;
        return this;
    }

    public FoodIngredientsKey build() {
        this.foodIngredientsKey  = new FoodIngredientsKey();
        this.foodIngredientsKey.setFood_id(this.food_id);
        this.foodIngredientsKey.setIngredient_id(this.ingredient_id);
        return foodIngredientsKey;
    }

}
