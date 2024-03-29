package com.munte.disertatiebackend.classes.dtos.fooddto;

import com.munte.disertatiebackend.classes.dtos.IngredientsDTO;
import com.munte.disertatiebackend.classes.dtos.TagsDTO;

import java.util.List;

public class FoodReceiveDTO {
    private String name;
    private Double price;
    private List<TagsDTO> tags;
    private List<IngredientsDTO> ingredients;
    private byte[] image;
    private Long cookTime;

    public Long getCookTime() {
        return cookTime;
    }

    public void setCookTime(Long timeToCook) {
        this.cookTime = timeToCook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<TagsDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagsDTO> tags) {
        this.tags = tags;
    }

    public List<IngredientsDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientsDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
