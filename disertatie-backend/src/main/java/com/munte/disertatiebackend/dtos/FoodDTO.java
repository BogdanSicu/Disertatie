package com.munte.disertatiebackend.dtos;

import com.munte.disertatiebackend.enums.FoodTags;

import java.io.File;
import java.util.List;

public class FoodDTO {
    private String name;
    private double price;
    private List<FoodTags> tags;
    private boolean favorite;
    private int stars;
    private File image;

    public FoodDTO() {
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

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }
}
