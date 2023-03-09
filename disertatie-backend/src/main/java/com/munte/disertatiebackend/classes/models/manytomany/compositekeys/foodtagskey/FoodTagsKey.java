package com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodtagskey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FoodTagsKey implements Serializable {

    @Column(name = "food_id")
    private Long food_id;

    @Column(name = "tag_id")
    private Long tag_id;

    public Long getFood_id() {
        return food_id;
    }

    public void setFood_id(Long food_id) {
        this.food_id = food_id;
    }

    public Long getTag_id() {
        return tag_id;
    }

    public void setTag_id(Long tag_id) {
        this.tag_id = tag_id;
    }
}
