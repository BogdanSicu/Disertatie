package com.munte.disertatiebackend.services.food;

import com.munte.disertatiebackend.classes.dtos.FoodDTO;
import com.munte.disertatiebackend.classes.models.Food;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FoodService {
    public List<Food> getAllFood();

    public List<FoodDTO> getAllFoodTEST();

    public ResponseEntity<String> saveNewFood(FoodDTO foodDto);
    public FoodDTO getFoodByName(String foodName);
}
