package com.munte.disertatiebackend.classes.models.manytomany;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.munte.disertatiebackend.classes.models.Food;
import com.munte.disertatiebackend.classes.models.Users;
import com.munte.disertatiebackend.classes.models.manytomany.compositekeys.favouritefoodskey.FavouriteFoodsKey;

import javax.persistence.*;

// many to many
@Entity
@Table(name = "FAVORITE_FOODS")
public class FavouriteFoods {
    @JsonIgnore
    @EmbeddedId
    FavouriteFoodsKey id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "food_id")
    private Food food;

    @JsonIgnore
    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "user_id")
    private Users user;

    public FavouriteFoodsKey getId() {
        return id;
    }

    public void setId(FavouriteFoodsKey id) {
        this.id = id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
