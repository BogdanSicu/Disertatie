package com.munte.disertatiebackend.mappers;

import com.munte.disertatiebackend.classes.dtos.IngredientsDTO;
import com.munte.disertatiebackend.classes.models.Ingredients;
import org.springframework.stereotype.Service;

@Service
public class IngredientsMapper {

    public IngredientsDTO toDTO(Ingredients ingredient) {
        IngredientsDTO ingredientsDTO =  new IngredientsDTO();
        ingredientsDTO.setName(ingredient.getName());
        return ingredientsDTO;
    }

}
