package com.munte.disertatiebackend.services.food;

import com.munte.disertatiebackend.classes.dtos.FoodReceiveDTO;
import com.munte.disertatiebackend.classes.dtos.FoodSendDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FoodService {
    public List<FoodSendDTO> getAllFood();

    public ResponseEntity<String> saveNewFood(FoodReceiveDTO foodReceiveDto);
    public FoodSendDTO getFoodByName(String foodName);
}
