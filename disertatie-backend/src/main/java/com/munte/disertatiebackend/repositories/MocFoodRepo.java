package com.munte.disertatiebackend.repositories;

import com.munte.disertatiebackend.classes.Food;
import com.munte.disertatiebackend.enums.FoodTags;

import java.util.ArrayList;
import java.util.Arrays;

public class MocFoodRepo {
    public static ArrayList<Food> listOfFoods =  new ArrayList<>();

    public static ArrayList<Food> getFood() {
        listOfFoods.add(new Food(
                1,
                "all cheese",
                34.5,
                Arrays.stream(FoodTags.values()).toList(),
                true,
                3,
                "src/main/java/com/munte/disertatiebackend/media/pizza_all_cheese.png"
        ));
        listOfFoods.add(new Food(
                1,
                "argentina",
                34.5,
                Arrays.stream(FoodTags.values()).toList(),
                true,
                3,
                "src/main/java/com/munte/disertatiebackend/media/pizza_argentina.png"));

        return listOfFoods;
    }
}
