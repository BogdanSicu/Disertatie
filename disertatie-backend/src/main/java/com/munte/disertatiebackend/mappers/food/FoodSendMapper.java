package com.munte.disertatiebackend.mappers.food;

import com.munte.disertatiebackend.classes.dtos.fooddto.FoodSendDTO;
import com.munte.disertatiebackend.classes.dtos.IngredientsDTO;
import com.munte.disertatiebackend.classes.dtos.TagsDTO;
import com.munte.disertatiebackend.classes.models.Food;
import com.munte.disertatiebackend.classes.models.Ingredients;
import com.munte.disertatiebackend.classes.models.Tags;
import com.munte.disertatiebackend.classes.models.manytomany.FoodIngredients;
import com.munte.disertatiebackend.classes.models.manytomany.FoodTags;
import com.munte.disertatiebackend.mappers.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FoodSendMapper implements Mapper<FoodSendDTO, Food> {

    private final Mapper<IngredientsDTO, Ingredients> ingredientsMapper;
    private final Mapper<TagsDTO, Tags> tagsMapper;

    public FoodSendMapper(Mapper<IngredientsDTO, Ingredients> ingredientsMapper, Mapper<TagsDTO, Tags> tagsMapper) {
        this.ingredientsMapper = ingredientsMapper;
        this.tagsMapper = tagsMapper;
    }

    @Override
    public FoodSendDTO toDTO(Food model) {
        FoodSendDTO dto = new FoodSendDTO();
        dto.setName(model.getName());
        dto.setPrice(model.getPrice());
        dto.setCookTime(model.getCookTime());
        dto.setIngredients(new ArrayList<>());
        dto.setImage(model.getImageURL());

        for (FoodIngredients ingredient : model.getFoodIngredients()) {
            dto.getIngredients().add(ingredientsMapper.toDTO(ingredient.getIngredient()));
        }

        dto.setTags(new ArrayList<>());
        for (FoodTags tag : model.getFoodTags()) {
            dto.getTags().add(tagsMapper.toDTO(tag.getTag()));
        }

        return dto ;
    }

    @Override
    public Food toModel(FoodSendDTO dto) {
        return null;
    }
}
