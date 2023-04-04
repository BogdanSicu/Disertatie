package com.munte.disertatiebackend.services.ingredients;

import com.munte.disertatiebackend.classes.dtos.IngredientsDTO;
import com.munte.disertatiebackend.classes.models.Ingredients;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IngredientsService {
    public List<IngredientsDTO> getAllIngredients();
    public ResponseEntity<String> saveNewIngredient(IngredientsDTO ingredientsDTO);
    public List<Ingredients> getAllModelIngredients();
    public Ingredients getIngredientByName(String name);
}
