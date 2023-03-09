package com.munte.disertatiebackend.classes.models.manytomany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.munte.disertatiebackend.classes.models.Food;
import com.munte.disertatiebackend.classes.models.Ingredients;
import com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodingredientskey.FoodIngredientsKey;

import javax.persistence.*;

// many to many
@Entity
@Table(name = "FOOD_INGREDIENTS")
public class FoodIngredients {

    @JsonIgnore
    @EmbeddedId
    FoodIngredientsKey id;

    @JsonIgnore
    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "ingredient_id")
    private Ingredients ingredient;

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

    public Ingredients getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredients ingredient) {
        this.ingredient = ingredient;
    }
}
