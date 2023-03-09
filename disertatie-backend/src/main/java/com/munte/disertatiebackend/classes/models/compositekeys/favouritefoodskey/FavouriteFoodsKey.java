package com.munte.disertatiebackend.classes.models.compositekeys.favouritefoodskey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FavouriteFoodsKey implements Serializable {
    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "food_id")
    private Long food_id;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getFood_id() {
        return food_id;
    }

    public void setFood_id(Long food_id) {
        this.food_id = food_id;
    }
}
