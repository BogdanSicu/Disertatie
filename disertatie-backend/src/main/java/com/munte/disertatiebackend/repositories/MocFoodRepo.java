package com.munte.disertatiebackend.repositories;

import com.munte.disertatiebackend.classes.MOCFood;
import com.munte.disertatiebackend.classes.MOCFoodTags;

import java.util.ArrayList;
import java.util.Arrays;

public class MocFoodRepo {
    public static ArrayList<MOCFood> listOfFoods =  new ArrayList<>();

    public static ArrayList<MOCFood> getFood() {
        listOfFoods.add(new MOCFood(
                1,
                "all cheese",
                34.5,
                Arrays.stream(MOCFoodTags.values()).toList(),
                true,
                3,
                "src/main/java/com/munte/disertatiebackend/media/pizza_all_cheese.png"
        ));
        listOfFoods.add(new MOCFood(
                1,
                "argentina",
                34.5,
                Arrays.stream(MOCFoodTags.values()).toList(),
                true,
                3,
                "src/main/java/com/munte/disertatiebackend/media/pizza_argentina.png"));

        return listOfFoods;
    }
}
