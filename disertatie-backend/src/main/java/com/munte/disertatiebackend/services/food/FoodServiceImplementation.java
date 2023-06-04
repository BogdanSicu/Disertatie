package com.munte.disertatiebackend.services.food;

import com.munte.disertatiebackend.classes.dtos.ChartData;
import com.munte.disertatiebackend.classes.dtos.fooddto.FoodReceiveDTO;
import com.munte.disertatiebackend.classes.dtos.fooddto.FoodSendDTO;
import com.munte.disertatiebackend.classes.dtos.IngredientsDTO;
import com.munte.disertatiebackend.classes.dtos.TagsDTO;
import com.munte.disertatiebackend.classes.models.foods.Food;
import com.munte.disertatiebackend.mappers.Mapper;
import com.munte.disertatiebackend.repositories.FoodRepository;
import com.munte.disertatiebackend.services.foodingredients.FoodIngredientsService;
import com.munte.disertatiebackend.services.foodtags.FoodTagsService;
import com.munte.disertatiebackend.services.ingredients.IngredientsService;
import com.munte.disertatiebackend.services.tags.TagsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class FoodServiceImplementation implements FoodService{

    private final FoodRepository foodRepository;
    private final IngredientsService ingredientsService;
    private final Mapper<FoodReceiveDTO, Food> foodReceiveMapper;
    private final Mapper<FoodSendDTO, Food> foodSendMapper;
    private final FoodIngredientsService foodIngredientsService;
    private final TagsService tagsService;
    private final FoodTagsService foodTagsService;

    public FoodServiceImplementation(FoodRepository foodRepository, IngredientsService ingredientsService, Mapper<FoodReceiveDTO, Food> foodReceiveMapper, Mapper<FoodSendDTO, Food> foodSendMapper, FoodIngredientsService foodIngredientsService, TagsService tagsService, FoodTagsService foodTagsService) {
        this.foodRepository = foodRepository;
        this.ingredientsService = ingredientsService;
        this.foodReceiveMapper = foodReceiveMapper;
        this.foodSendMapper = foodSendMapper;
        this.foodIngredientsService = foodIngredientsService;
        this.tagsService = tagsService;
        this.foodTagsService = foodTagsService;
    }

    @Override
    public List<FoodSendDTO> getAllFood() {
        return foodRepository.findAll().stream().map(foodSendMapper::toDTO).toList();
    }

    @Override
    public ResponseEntity<String> saveNewFood(FoodReceiveDTO foodReceiveDto) {
        if(foodReceiveDto == null) {
            return ResponseEntity.noContent().build();
        }

        if(foodRepository.findAll().stream().filter(x -> x.getName().equals(foodReceiveDto.getName())).toList().size() == 0) {
            Food newFood = foodRepository.save(foodReceiveMapper.toModel(foodReceiveDto));
            this.savePicture(newFood.getImageURL(), foodReceiveDto.getImage());


            for (IngredientsDTO ingredientsDTO : foodReceiveDto.getIngredients()) {
                ingredientsService.saveNewIngredient(ingredientsDTO);
                foodIngredientsService.saveNewRelation(newFood.getId(), ingredientsService.getIngredientByName(ingredientsDTO.getName()).getId());
            }

            for(TagsDTO tagsDTO : foodReceiveDto.getTags()) {
                tagsService.saveNewTag(tagsDTO);
                foodTagsService.saveNewRelation(newFood.getId(), tagsService.getTagsByName(tagsDTO.getName()).getId());
            }

            return ResponseEntity.ok("The food was created");
        }

        return ResponseEntity.badRequest().body("This food already exists");
    }

    @Override
    public FoodSendDTO getFoodByName(String foodName) {
        Food food = foodRepository.findByName(foodName);
        if(food != null) {
            return foodSendMapper.toDTO(food);
        }
        return null;
    }

    @Override
    public List<ChartData> getChartData() {
        return foodRepository.getChartData();
    }

    private void savePicture(String path, byte[] image) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(image);
            fos.close();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
