package com.munte.disertatiebackend.classes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.munte.disertatiebackend.classes.models.compositekeys.FoodTagsKey;

import javax.persistence.*;

// many to many
@Entity
@Table(name = "FOOD_TAGS")
public class FoodTags {

    @JsonIgnore
    @EmbeddedId
    private FoodTagsKey id;

    @JsonIgnore
    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "tag_id")
    private Tags tags;

    public FoodTagsKey getId() {
        return id;
    }

    public void setId(FoodTagsKey id) {
        this.id = id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }
}
