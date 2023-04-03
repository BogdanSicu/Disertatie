package com.munte.disertatiebackend.services.food;

import com.munte.disertatiebackend.classes.dtos.FoodDTO;
import com.munte.disertatiebackend.classes.models.Food;

import java.util.List;

public interface FoodService {
    public List<Food> getAllFood();

    public List<FoodDTO> getAllFoodTEST();
}
