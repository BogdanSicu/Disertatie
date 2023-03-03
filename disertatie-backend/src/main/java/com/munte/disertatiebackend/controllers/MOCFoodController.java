package com.munte.disertatiebackend.controllers;

import com.munte.disertatiebackend.classes.dtos.MOCFoodDTO;
import com.munte.disertatiebackend.services.MOCFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/food/")
public class MOCFoodController {

    private final MOCFoodService foodService;

    @Autowired
    public MOCFoodController(MOCFoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("getAllFood")
    public List<MOCFoodDTO> getAllFood() {
        return foodService.getAllFood();
    }

}
