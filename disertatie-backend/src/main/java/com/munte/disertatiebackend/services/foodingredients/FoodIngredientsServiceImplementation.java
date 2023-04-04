package com.munte.disertatiebackend.services.foodingredients;

import com.munte.disertatiebackend.classes.models.manytomany.FoodIngredients;
import com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodingredientskey.FoodIngredientsKeyBuilder;
import com.munte.disertatiebackend.repositories.FoodIngredientsRepository;
import com.munte.disertatiebackend.repositories.FoodRepository;
import com.munte.disertatiebackend.repositories.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodIngredientsServiceImplementation implements FoodIngredientsService{

    private final FoodIngredientsRepository foodIngredientsRepository;
    private final FoodRepository foodRepository;
    private final IngredientsRepository ingredientsRepository;

    @Autowired
    public FoodIngredientsServiceImplementation(FoodIngredientsRepository foodIngredientsRepository, FoodRepository foodRepository, IngredientsRepository ingredientsRepository) {
        this.foodIngredientsRepository = foodIngredientsRepository;
        this.foodRepository = foodRepository;
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public void saveNewRelation(Long foodId, Long ingredientId) {
        if(foodRepository.findById(foodId).isPresent() && ingredientsRepository.findById(ingredientId).isPresent()) {
            FoodIngredients foodIngredients = new FoodIngredients();
            foodIngredients.setId(new FoodIngredientsKeyBuilder().addFoodId(foodId).addIngredientId(ingredientId).build());
            foodIngredientsRepository.save(foodIngredients);
        }
    }
}
