package com.munte.disertatiebackend.classes;

import com.munte.disertatiebackend.enums.FoodTags;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Food implements Serializable {
    private int id;
    private String name;
    private double price;
    private List<FoodTags> tags;
    private boolean favorite;
    private int stars;
    private String imageUrl;

    public Food(int id, String name, double price, List<FoodTags> tags, boolean favorite, int stars, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.tags = tags;
        this.favorite = favorite;
        this.stars = stars;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<FoodTags> getTags() {
        return tags;
    }

    public void setTags(List<FoodTags> tags) {
        this.tags = tags;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
