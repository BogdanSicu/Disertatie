package com.munte.disertatiebackend.services;

import com.munte.disertatiebackend.classes.Food;
import com.munte.disertatiebackend.dtos.FoodDTO;
import com.munte.disertatiebackend.mappers.FoodMapper;
import com.munte.disertatiebackend.repositories.MocFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {

    private final FoodMapper foodMapper;

    @Autowired
    public FoodService(FoodMapper foodMapper) {
        this.foodMapper = foodMapper;
    }

    public List<FoodDTO> getAllFood() {
        List<FoodDTO> myList =  new ArrayList<>();

        for (Food food : MocFoodRepo.getFood()) {
            myList.add(foodMapper.modelToDTO(food));
        }

        return myList;
    }
}
