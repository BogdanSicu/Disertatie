package com.munte.disertatiebackend.controllers;

import com.munte.disertatiebackend.classes.Food;
import com.munte.disertatiebackend.dtos.FoodDTO;
import com.munte.disertatiebackend.repositories.MocFoodRepo;
import com.munte.disertatiebackend.services.FoodService;
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

    @GetMapping("getAllFood")
    public List<FoodDTO> getAllFood() {
        return foodService.getAllFood();
    }

}
