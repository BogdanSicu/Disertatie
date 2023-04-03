package com.munte.disertatiebackend.services.food;

import com.munte.disertatiebackend.classes.dtos.FoodDTO;
import com.munte.disertatiebackend.classes.models.Food;
import com.munte.disertatiebackend.mappers.Mapper;
import com.munte.disertatiebackend.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImplementation implements FoodService{

    private final FoodRepository foodRepository;

    private final Mapper<FoodDTO, Food> foodMapper;

    @Autowired
    public FoodServiceImplementation(FoodRepository foodRepository, Mapper<FoodDTO, Food> foodMapper) {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
    }

    public List<Food> getAllFood() {
        return foodRepository.findAll().stream().toList();
    }

    @Override
    public List<FoodDTO> getAllFoodTEST() {
        return foodRepository.findAll().stream().map(foodMapper::toDTO).toList();
    }
}
