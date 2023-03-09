package com.munte.disertatiebackend.repositories;

import com.munte.disertatiebackend.classes.models.FoodTags;
import com.munte.disertatiebackend.classes.models.compositekeys.foodtagskey.FoodTagsKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodTagsRepository extends JpaRepository<FoodTags, FoodTagsKey> {
}
