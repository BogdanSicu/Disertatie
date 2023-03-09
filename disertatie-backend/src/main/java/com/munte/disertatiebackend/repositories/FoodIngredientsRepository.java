package com.munte.disertatiebackend.repositories;

import com.munte.disertatiebackend.classes.models.FoodIngredients;
import com.munte.disertatiebackend.classes.models.compositekeys.foodingredientskey.FoodIngredientsKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodIngredientsRepository extends JpaRepository<FoodIngredients, FoodIngredientsKey> {
}
