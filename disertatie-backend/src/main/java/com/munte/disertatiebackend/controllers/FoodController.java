package com.munte.disertatiebackend.controllers;

import com.munte.disertatiebackend.classes.dtos.fooddto.FoodReceiveDTO;
import com.munte.disertatiebackend.classes.dtos.fooddto.FoodSendDTO;
import com.munte.disertatiebackend.services.food.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/food/")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("get-all-food-test")
    public List<FoodSendDTO> getAllFoodTEST() {
        return foodService.getAllFood();
    }

    @GetMapping("get-food-by-name")
    public FoodSendDTO getFoodByName(@RequestParam String name) {
        return foodService.getFoodByName(name);
    }

    @PostMapping("save-food")
    public ResponseEntity<String> saveFood(@RequestBody FoodReceiveDTO foodReceiveDto) {
        return foodService.saveNewFood(foodReceiveDto);
    }
}
