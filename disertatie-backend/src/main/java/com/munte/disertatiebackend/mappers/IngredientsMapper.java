package com.munte.disertatiebackend.mappers;

import com.munte.disertatiebackend.classes.dtos.IngredientsDTO;
import com.munte.disertatiebackend.classes.models.Ingredients;
import org.springframework.stereotype.Service;

@Service
public class IngredientsMapper implements Mapper<IngredientsDTO, Ingredients> {

    public IngredientsDTO toDTO(Ingredients ingredient) {
        IngredientsDTO ingredientsDTO =  new IngredientsDTO();
        ingredientsDTO.setName(ingredient.getName());
        return ingredientsDTO;
    }

    @Override
    public Ingredients toModel(IngredientsDTO dto) {
        Ingredients ingredient = new Ingredients();
        ingredient.setName(dto.getName());
        return ingredient;
    }

}
