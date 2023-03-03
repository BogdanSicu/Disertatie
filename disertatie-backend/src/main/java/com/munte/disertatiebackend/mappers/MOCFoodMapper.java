package com.munte.disertatiebackend.mappers;

import com.munte.disertatiebackend.classes.MOCFood;
import com.munte.disertatiebackend.classes.dtos.MOCFoodDTO;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class MOCFoodMapper {

    public MOCFoodMapper() {
    }

    public MOCFoodDTO modelToDTO(MOCFood food){
        MOCFoodDTO foodDTO = new MOCFoodDTO();

        foodDTO.setName(food.getName());
        foodDTO.setFavorite(food.isFavorite());
        foodDTO.setPrice(food.getPrice());
        foodDTO.setStars(food.getStars());
        foodDTO.setTags(food.getTags());

        try {
            foodDTO.setImage(Files.readAllBytes(Paths.get(food.getImageUrl())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return foodDTO;
    }
}
