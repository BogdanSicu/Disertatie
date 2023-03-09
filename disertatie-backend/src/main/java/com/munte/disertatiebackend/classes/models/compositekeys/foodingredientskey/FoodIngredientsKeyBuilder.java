package com.munte.disertatiebackend.classes.models.compositekeys.foodingredientskey;

public class FoodIngredientsKeyBuilder {

    private FoodIngredientsKey foodIngredientsKey = new FoodIngredientsKey();

    private Long food_id;

    private Long ingredient_id;

    public FoodIngredientsKeyBuilder addFoodId(Long food_id) {
        this.foodIngredientsKey.setFood_id(food_id);
        return this;
    }

    public FoodIngredientsKeyBuilder addIngredientId(Long ingredient_id) {
        this.foodIngredientsKey.setIngredient_id(ingredient_id);
        return this;
    }

    public FoodIngredientsKey build() {
        return foodIngredientsKey;
    }

}
