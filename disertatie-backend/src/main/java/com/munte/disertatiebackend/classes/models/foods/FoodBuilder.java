package com.munte.disertatiebackend.classes.models.foods;

public class FoodBuilder {
    private String name;
    private String imageURL;
    private Double price;
    private Long cookTime;

    public FoodBuilder addName(String name) {
        this.name = name;
        return this;
    }

    public FoodBuilder addImage(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public FoodBuilder addPrice(Double price) {
        this.price = price;
        return this;
    }

    public FoodBuilder addCookingTime(Long cookTime) {
        this.cookTime = cookTime;
        return this;
    }

    public Food build() {
        Food food = new Food();

        food.setName(this.name);
        food.setImageURL(this.imageURL);
        food.setPrice(this.price);
        food.setCookTime(this.cookTime);

        return food;
    }
}
