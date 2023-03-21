package com.munte.disertatiebackend.services.food;

import com.munte.disertatiebackend.classes.models.Food;
import com.munte.disertatiebackend.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImplementation implements FoodService{

    private final FoodRepository foodRepository;

    @Autowired
    public FoodServiceImplementation(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAllFood() {
        return foodRepository.findAll().stream().toList();
    }
}
