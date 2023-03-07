package com.munte.disertatiebackend.configurations;

import com.munte.disertatiebackend.classes.models.Food;
import com.munte.disertatiebackend.classes.models.FoodTags;
import com.munte.disertatiebackend.classes.models.Tags;
import com.munte.disertatiebackend.classes.models.compositekeys.FoodTagsKeyBuilder;
import com.munte.disertatiebackend.repositories.FoodRepository;
import com.munte.disertatiebackend.repositories.FoodTagsRepository;
import com.munte.disertatiebackend.repositories.TagsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class Configurations {

    @Bean(name = "food-configuration")
    CommandLineRunner addDefaultFood(FoodRepository foodRepository) {
        return args -> {
            Food pizza_all_cheese = new Food();
            pizza_all_cheese.setName("Pizza All Cheese");
            pizza_all_cheese.setImageURL("src/main/java/com/munte/disertatiebackend/media/pizza_all_cheese.png");
            pizza_all_cheese.setPrice(30.00);

            foodRepository.save(pizza_all_cheese);
        };
    }

    @Bean(name = "tags-configuration")
    CommandLineRunner addDefaultTags(TagsRepository tagsRepository) {
        return args -> {
            Tags pizza =  new Tags();
            pizza.setName("Pizza");

            tagsRepository.save(pizza);
        };
    }

    @Bean
    @DependsOn({"tags-configuration", "food-configuration"})
    CommandLineRunner addManyToManyDataForFoodAndTags(FoodTagsRepository foodTagsRepository, FoodRepository foodRepository, TagsRepository tagsRepository) {
        return args -> {
            FoodTags pizza_all_cheese_tag = new FoodTags();
//            pizza_all_cheese_tag.setFood(foodRepository.findAll().stream().filter(food -> food.getName().equals("Pizza All Cheese")).toList().get(0));
//            pizza_all_cheese_tag.setTags(tagsRepository.findAll().stream().filter(tags -> tags.getName().equals("Pizza")).toList().get(0));
//            pizza_all_cheese_tag.setId(new FoodTagsKeyBuilder().addFoodId(pizza_all_cheese_tag.getFood().getId()).addTagsId(pizza_all_cheese_tag.getTags().getId()).build());

            pizza_all_cheese_tag.setId(new FoodTagsKeyBuilder().addFoodId(1L).addTagsId(1L).build());
            foodTagsRepository.save(pizza_all_cheese_tag);
        };
    }

}
