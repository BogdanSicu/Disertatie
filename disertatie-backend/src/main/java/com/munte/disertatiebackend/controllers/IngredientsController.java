package com.munte.disertatiebackend.controllers;

import com.munte.disertatiebackend.classes.dtos.IngredientsDTO;
import com.munte.disertatiebackend.services.ingredients.IngredientsService;
import com.munte.disertatiebackend.services.ingredients.IngredientsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/ingredients/")
public class IngredientsController {

    private final IngredientsService ingredientsService;

    @Autowired
    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping("get-all-ingredients")
    public ResponseEntity<List<IngredientsDTO>> getAllIngredients() {
        return ResponseEntity.ok(ingredientsService.getAllIngredients());
    }

    @PostMapping()
    public ResponseEntity<IngredientsDTO> saveNewIngredients(@RequestBody IngredientsDTO ingredientsDTO) {
        return ingredientsService.saveNewIngredient(ingredientsDTO);
    }
}
