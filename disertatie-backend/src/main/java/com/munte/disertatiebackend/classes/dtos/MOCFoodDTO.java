package com.munte.disertatiebackend.classes.dtos;

import com.munte.disertatiebackend.classes.MOCFoodTags;

import java.util.List;

public class MOCFoodDTO {
    private String name;
    private double price;
    private List<MOCFoodTags> tags;
    private boolean favorite;
    private int stars;
    private byte[] image;

    public MOCFoodDTO() {
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
