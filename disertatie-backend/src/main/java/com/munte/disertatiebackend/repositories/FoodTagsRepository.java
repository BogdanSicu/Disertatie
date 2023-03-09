package com.munte.disertatiebackend.repositories;

import com.munte.disertatiebackend.classes.models.manytomany.FoodTags;
import com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodtagskey.FoodTagsKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodTagsRepository extends JpaRepository<FoodTags, FoodTagsKey> {
}
