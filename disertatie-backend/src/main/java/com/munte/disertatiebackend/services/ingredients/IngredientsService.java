package com.munte.disertatiebackend.services.ingredients;

import com.munte.disertatiebackend.classes.dtos.IngredientsDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IngredientsService {
    public List<IngredientsDTO> getAllIngredients();
    public ResponseEntity<IngredientsDTO> saveNewIngredient(IngredientsDTO ingredientsDTO);
}
