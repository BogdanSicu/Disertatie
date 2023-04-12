package com.munte.disertatiebackend.services.food;

import com.munte.disertatiebackend.classes.dtos.FoodDTO;
import com.munte.disertatiebackend.classes.dtos.IngredientsDTO;
import com.munte.disertatiebackend.classes.dtos.TagsDTO;
import com.munte.disertatiebackend.classes.models.Food;
import com.munte.disertatiebackend.mappers.Mapper;
import com.munte.disertatiebackend.repositories.FoodRepository;
import com.munte.disertatiebackend.services.foodingredients.FoodIngredientsService;
import com.munte.disertatiebackend.services.foodtags.FoodTagsService;
import com.munte.disertatiebackend.services.ingredients.IngredientsService;
import com.munte.disertatiebackend.services.tags.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class FoodServiceImplementation implements FoodService{

    private final FoodRepository foodRepository;

    private final IngredientsService ingredientsService;

    private final Mapper<FoodDTO, Food> foodMapper;
    private final FoodIngredientsService foodIngredientsService;
    private final TagsService tagsService;
    private final FoodTagsService foodTagsService;

    @Autowired
    public FoodServiceImplementation(FoodRepository foodRepository, IngredientsService ingredientsService, Mapper<FoodDTO, Food> foodMapper, FoodIngredientsService foodIngredientsService, TagsService tagsService, FoodTagsService foodTagsService) {
        this.foodRepository = foodRepository;
        this.ingredientsService = ingredientsService;
        this.foodMapper = foodMapper;
        this.foodIngredientsService = foodIngredientsService;
        this.tagsService = tagsService;
        this.foodTagsService = foodTagsService;
    }

    public List<Food> getAllFood() {
        return foodRepository.findAll().stream().toList();
    }

    @Override
    public List<FoodDTO> getAllFoodTEST() {
        return foodRepository.findAll().stream().map(foodMapper::toDTO).toList();
    }

    @Override
    public ResponseEntity<String> saveNewFood(FoodDTO foodDto) {
        if(foodDto == null) {
            return ResponseEntity.noContent().build();
        }

        if(foodRepository.findAll().stream().filter(x -> x.getName().equals(foodDto.getName())).toList().size() == 0) {
            Food newFood = foodRepository.save(foodMapper.toModel(foodDto));
            this.savePicture(newFood.getImageURL(), foodDto.getImage());


            for (IngredientsDTO ingredientsDTO : foodDto.getIngredients()) {
                ingredientsService.saveNewIngredient(ingredientsDTO);
                foodIngredientsService.saveNewRelation(newFood.getId(), ingredientsService.getIngredientByName(ingredientsDTO.getName()).getId());
            }

            for(TagsDTO tagsDTO : foodDto.getTags()) {
                tagsService.saveNewTag(tagsDTO);
                foodTagsService.saveNewRelation(newFood.getId(), tagsService.getTagsByName(tagsDTO.getName()).getId());
            }

            return ResponseEntity.ok("The food was created");
        }

        return ResponseEntity.badRequest().body("This food already exists");
    }

    @Override
    public FoodDTO getFoodByName(String foodName) {
        Food food = foodRepository.findByName(foodName);
        if(food != null) {
            return foodMapper.toDTO(food);
        }
        return null;
    }

    private void savePicture(String path, byte[] image) {
        try {
            FileOutputStream fos = new FileOutputStream(path + ".png");
            fos.write(image);
            fos.close();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
