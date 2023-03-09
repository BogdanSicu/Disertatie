package com.munte.disertatiebackend.classes.models.compositekeys.foodingredientskey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FoodIngredientsKey implements Serializable {
    @Column(name = "food_id")
    private Long food_id;
    @Column(name = "ingredient_id")
    private Long ingredient_id;

    public Long getFood_id() {
        return food_id;
    }

    public void setFood_id(Long food_id) {
        this.food_id = food_id;
    }

    public Long getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }
}
