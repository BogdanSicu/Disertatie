package com.munte.disertatiebackend.services.ingredients;

import com.munte.disertatiebackend.classes.dtos.IngredientsDTO;
import com.munte.disertatiebackend.classes.models.Ingredients;
import com.munte.disertatiebackend.mappers.IngredientsMapper;
import com.munte.disertatiebackend.repositories.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientsServiceImplementation implements IngredientsService{

    private final IngredientsRepository ingredientsRepository;
    private final IngredientsMapper ingredientsMapper;

    @Autowired
    public IngredientsServiceImplementation(IngredientsRepository ingredientsRepository, IngredientsMapper ingredientsMapper) {
        this.ingredientsRepository = ingredientsRepository;
        this.ingredientsMapper = ingredientsMapper;
    }

    public List<IngredientsDTO> getAllIngredients() {
        return ingredientsRepository.findAll().stream().map(ingredientsMapper::toDTO).toList();
    }

    public ResponseEntity<String> saveNewIngredient(IngredientsDTO ingredientsDTO) {
        if(ingredientsDTO == null) {
            return ResponseEntity.noContent().build();
        }

        if(ingredientsRepository.findByName(ingredientsDTO.getName()) == null) {
            ingredientsRepository.save(ingredientsMapper.toModel(ingredientsDTO));
            return ResponseEntity.ok("The ingredient was created");
        }

        return ResponseEntity.badRequest().body("This ingredient already exists");
    }

    @Override
    public List<Ingredients> getAllModelIngredients() {
        return ingredientsRepository.findAll();
    }

    @Override
    public Ingredients getIngredientByName(String name) {
        return ingredientsRepository.findByName(name);
    }


}
