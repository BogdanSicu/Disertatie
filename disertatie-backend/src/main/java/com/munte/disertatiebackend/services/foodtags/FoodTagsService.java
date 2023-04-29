package com.munte.disertatiebackend.services.foodtags;

import com.munte.disertatiebackend.classes.models.manytomany.FoodTags;

import java.util.List;

public interface FoodTagsService {
    public void saveNewRelation(Long foodId, Long tagId);

    public List<FoodTags> getAllRelations();
}
