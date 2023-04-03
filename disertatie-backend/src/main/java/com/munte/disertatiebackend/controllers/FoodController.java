package com.munte.disertatiebackend.controllers;

import com.munte.disertatiebackend.classes.dtos.FoodDTO;
import com.munte.disertatiebackend.classes.models.Food;
import com.munte.disertatiebackend.services.food.FoodService;
import com.munte.disertatiebackend.services.food.FoodServiceImplementation;
import com.munte.disertatiebackend.services.ingredients.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/food/")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("get-all-food")
    public List<Food> getAllFood() {
        List<Food> newList = new ArrayList<>();
        newList = foodService.getAllFood();
        return newList;
    }

    @GetMapping("get-all-food-test")
    public List<FoodDTO> getAllFoodTEST() {
        List<FoodDTO> newList = new ArrayList<>();
        newList = foodService.getAllFoodTEST();
        return newList;
    }
}
