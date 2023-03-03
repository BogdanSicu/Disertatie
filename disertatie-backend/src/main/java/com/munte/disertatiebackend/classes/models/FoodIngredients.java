package com.munte.disertatiebackend.classes.models;

import com.munte.disertatiebackend.classes.models.compositekeys.FoodIngredientsKey;

import javax.persistence.*;

// many to many
@Entity
@Table(name = "FOOD_INGREDIENTS")
public class FoodIngredients {

    @EmbeddedId
    FoodIngredientsKey id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "ingredient_id")
    private Ingredients ingredients;

    public FoodIngredientsKey getId() {
        return id;
    }

    public void setId(FoodIngredientsKey id) {
        this.id = id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }
}
