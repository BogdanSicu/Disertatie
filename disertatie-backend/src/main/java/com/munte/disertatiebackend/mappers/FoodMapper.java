package com.munte.disertatiebackend.mappers;

import com.munte.disertatiebackend.classes.dtos.FoodDTO;
import com.munte.disertatiebackend.classes.dtos.IngredientsDTO;
import com.munte.disertatiebackend.classes.dtos.TagsDTO;
import com.munte.disertatiebackend.classes.models.Food;
import com.munte.disertatiebackend.classes.models.Ingredients;
import com.munte.disertatiebackend.classes.models.Tags;
import com.munte.disertatiebackend.classes.models.manytomany.FoodIngredients;
import com.munte.disertatiebackend.classes.models.manytomany.FoodTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class FoodMapper implements Mapper<FoodDTO, Food> {

    private final Mapper<IngredientsDTO, Ingredients> ingredientsMapper;
    private final Mapper<TagsDTO, Tags> tagsMapper;

    @Autowired
    public FoodMapper(Mapper<IngredientsDTO, Ingredients> ingredientsMapper, Mapper<TagsDTO, Tags> tagsMapper) {
        this.ingredientsMapper = ingredientsMapper;
        this.tagsMapper = tagsMapper;
    }

    @Override
    public FoodDTO toDTO(Food model) {
        FoodDTO dto = new FoodDTO();
        dto.setName(model.getName());
        dto.setPrice(model.getPrice());
        dto.setCookTime(model.getCookTime());
        dto.setIngredients(new ArrayList<>());
        for (FoodIngredients ingredient : model.getFoodIngredients()) {
            dto.getIngredients().add(ingredientsMapper.toDTO(ingredient.getIngredient()));
        }
        dto.setTags(new ArrayList<>());
        for (FoodTags tag : model.getFoodTags()) {
            dto.getTags().add(tagsMapper.toDTO(tag.getTag()));
        }

        try {
            dto.setImage(Files.readAllBytes(Paths.get(model.getImageURL())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return dto;
    }

    @Override
    public Food toModel(FoodDTO dto) {
        Food model = new Food();
        model.setPrice(dto.getPrice());
        model.setName(dto.getName());
        model.setCookTime(dto.getCookTime());
        model.setImageURL("src/main/java/com/munte/disertatiebackend/media/" + model.getName().toLowerCase().replace(" ", "_"));
        return model;
    }
}
