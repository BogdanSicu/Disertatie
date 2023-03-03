package com.munte.disertatiebackend.classes;

import java.io.Serializable;
import java.util.List;

public class MOCFood implements Serializable {
    private int id;
    private String name;
    private double price;
    private List<MOCFoodTags> tags;
    private boolean favorite;
    private int stars;
    private String imageUrl;

    public MOCFood(int id, String name, double price, List<MOCFoodTags> tags, boolean favorite, int stars, String imageUrl) {
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

    public List<MOCFoodTags> getTags() {
        return tags;
    }

    public void setTags(List<MOCFoodTags> tags) {
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
