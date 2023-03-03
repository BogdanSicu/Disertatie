package com.munte.disertatiebackend.services;

import com.munte.disertatiebackend.classes.MOCFood;
import com.munte.disertatiebackend.classes.dtos.MOCFoodDTO;
import com.munte.disertatiebackend.mappers.MOCFoodMapper;
import com.munte.disertatiebackend.repositories.MocFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MOCFoodService {

    private final MOCFoodMapper foodMapper;

    @Autowired
    public MOCFoodService(MOCFoodMapper foodMapper) {
        this.foodMapper = foodMapper;
    }

    public List<MOCFoodDTO> getAllFood() {
        List<MOCFoodDTO> myList =  new ArrayList<>();

        for (MOCFood food : MocFoodRepo.getFood()) {
            myList.add(foodMapper.modelToDTO(food));
        }

        return myList;
    }
}
