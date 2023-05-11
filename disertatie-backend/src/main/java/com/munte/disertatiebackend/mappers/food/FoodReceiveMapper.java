package com.munte.disertatiebackend.mappers.food;

import com.munte.disertatiebackend.classes.dtos.fooddto.FoodReceiveDTO;
import com.munte.disertatiebackend.classes.models.Food;
import com.munte.disertatiebackend.mappers.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class FoodReceiveMapper implements Mapper<FoodReceiveDTO, Food> {

    @Override
    public FoodReceiveDTO toDTO(Food model) {
        return null;
    }

    @Override
    public Food toModel(FoodReceiveDTO dto) {
        Food model = new Food();
        model.setPrice(dto.getPrice());
        model.setName(dto.getName());
        model.setCookTime(dto.getCookTime());
        model.setImageURL("src/main/resources/static/images/" + model.getName().toLowerCase().replace(" ", "_") + ".png");
        return model;
    }
}
