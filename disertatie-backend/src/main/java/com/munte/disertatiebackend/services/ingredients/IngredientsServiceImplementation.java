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
    public IngredientsServiceImplementation(IngredientsRepository ingredientsRepository, IngredientsMapper ingredientsMapper1) {
        this.ingredientsRepository = ingredientsRepository;
        this.ingredientsMapper = ingredientsMapper1;
    }

    public List<IngredientsDTO> getAllIngredients() {
        List<IngredientsDTO> listDTO = new ArrayList<>();
        for (Ingredients ingredient: ingredientsRepository.findAll().stream().toList()) {
            listDTO.add(ingredientsMapper.toDTO(ingredient));
        }
        return listDTO;
    }

    public ResponseEntity<IngredientsDTO> saveNewIngredient(IngredientsDTO ingredientsDTO) {
        if(ingredientsDTO != null) {
            Ingredients newIngredient = new Ingredients();
            newIngredient.setName(ingredientsDTO.getName());
            ingredientsRepository.save(newIngredient);
            return ResponseEntity.ok(ingredientsDTO);
        } else {
            return ResponseEntity.badRequest().body(ingredientsDTO);
        }
    }
}
