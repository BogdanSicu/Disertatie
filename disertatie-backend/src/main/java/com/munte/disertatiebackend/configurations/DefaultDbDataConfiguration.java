package com.munte.disertatiebackend.configurations;

import com.munte.disertatiebackend.classes.models.*;
import com.munte.disertatiebackend.classes.models.addresses.Addresses;
import com.munte.disertatiebackend.classes.models.addresses.AddressesBuilder;
import com.munte.disertatiebackend.classes.models.manytomany.FoodsInOrders;
import com.munte.disertatiebackend.classes.models.manytomany.compositekeys.favouritefoodskey.FavouriteFoodsKeyBuilder;
import com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodingredientskey.FoodIngredientsKeyBuilder;
import com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodsinorders.FoodsInOrdersKeyBuilder;
import com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodtagskey.FoodTagsKeyBuilder;
import com.munte.disertatiebackend.classes.models.manytomany.FavouriteFoods;
import com.munte.disertatiebackend.classes.models.manytomany.FoodIngredients;
import com.munte.disertatiebackend.classes.models.manytomany.FoodTags;
import com.munte.disertatiebackend.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.List;

@Configuration
public class DefaultDbDataConfiguration {

    @Bean(name = "food-configuration")
    CommandLineRunner addDefaultFood(FoodRepository foodRepository) {
        return args -> {
            Food pizza_all_cheese = new Food();
            pizza_all_cheese.setName("Pizza All Cheese");
            pizza_all_cheese.setImageURL("src/main/java/com/munte/disertatiebackend/media/pizza_all_cheese.png");
            pizza_all_cheese.setPrice(30.00);
            pizza_all_cheese.setCookTime(45L);

            Food pizza_argentina = new Food();
            pizza_argentina.setName("Pizza Argentina");
            pizza_argentina.setImageURL("src/main/java/com/munte/disertatiebackend/media/pizza_argentina.png");
            pizza_argentina.setPrice(30.00);
            pizza_argentina.setCookTime(45L);

            foodRepository.save(pizza_all_cheese);
            foodRepository.save(pizza_argentina);
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

    @Bean(name = "ingredients-configuration")
    CommandLineRunner addDefaultIngredients(IngredientsRepository ingredientsRepository) {
        return args -> {
            Ingredients cheese = new Ingredients();
            cheese.setName("Cheese");

            ingredientsRepository.save(cheese);
        };
    }

    @Bean(name = "food-ingredients-relation")
    @DependsOn({"ingredients-configuration", "food-configuration"})
    CommandLineRunner addManyToManyDataForFoodAndIngredients(FoodIngredientsRepository foodIngredientsRepository) {
        return args -> {
            FoodIngredients pizza_all_cheese_ingredient1 = new FoodIngredients();

            pizza_all_cheese_ingredient1.setId(new FoodIngredientsKeyBuilder().addIngredientId(1L).addFoodId(1L).build());
            foodIngredientsRepository.save(pizza_all_cheese_ingredient1);

        };
    }

    @Bean(name = "food-tags-relation")
    @DependsOn({"tags-configuration", "food-configuration"})
    CommandLineRunner addManyToManyDataForFoodAndTags(FoodTagsRepository foodTagsRepository) {
        return args -> {
            FoodTags pizza_all_cheese_tag = new FoodTags();

//            pizza_all_cheese_tag.setFood(foodRepository.findAll().stream().filter(food -> food.getName().equals("Pizza All Cheese")).toList().get(0));
//            pizza_all_cheese_tag.setTags(tagsRepository.findAll().stream().filter(tags -> tags.getName().equals("Pizza")).toList().get(0));
//            pizza_all_cheese_tag.setId(new FoodTagsKeyBuilder().addFoodId(pizza_all_cheese_tag.getFood().getId()).addTagsId(pizza_all_cheese_tag.getTags().getId()).build());


            pizza_all_cheese_tag.setId(new FoodTagsKeyBuilder().addFoodId(1L).addTagsId(1L).build());
            foodTagsRepository.save(pizza_all_cheese_tag);
        };
    }

    @Bean(name = "roles-configuration")
    CommandLineRunner addDefaultRoles(RolesRepository rolesRepository) {
        return args -> {

            UserRoles admin = new UserRoles();
            admin.setName("Admin");
            UserRoles defaultUser = new UserRoles();
            defaultUser.setName("Default");

            rolesRepository.saveAll(List.of(admin, defaultUser));
        };
    }

    @Bean(name = "addresses-configuration")
    CommandLineRunner addDefaultAddresses(AddressesRepository addressesRepository) {
        return args -> {
            Addresses address1 = new AddressesBuilder().addCountry("Romania").addCounty("Bucharest").addCity("Bucharest").addStreet("Bd. Timisoara").addStreetNumber(89L).addBuilding("C 1.3").addStaircase("A").addRoom(10L).build();

            addressesRepository.save(address1);
        };
    }

    @Bean(name = "users-configuration")
    @DependsOn({"addresses-configuration", "roles-configuration"})
    CommandLineRunner addDefaultUsers(UsersRepository usersRepository, RolesRepository rolesRepository, AddressesRepository addressesRepository) {
        return args -> {

            Users admin = new Users();
            admin.setName("admin_test");
            admin.setPassword("1234");
            admin.setMail("admin_test@gmail.com");

            admin.setAddress(addressesRepository.findAll().stream().filter(addresses -> addresses.getCity().equals("Bucharest") && addresses.getBuilding().equals("C 1.3") && addresses.getRoom() == 10L).toList().get(0));
            admin.setRole(rolesRepository.findAll().stream().filter(role -> role.getName().equals("Admin")).toList().get(0));

            usersRepository.save(admin);
        };
    }

    @Bean(name = "user-favourite-foods-configuration")
    @DependsOn({"users-configuration", "food-configuration"})
    CommandLineRunner addDefaultFavouriteFoods(FavouriteFoodRepository favouriteFoodRepository) {
        return args -> {

            FavouriteFoods favouriteFoods = new FavouriteFoods();
            favouriteFoods.setId(new FavouriteFoodsKeyBuilder().addFoodId(1L).addUserId(1L).build());

            favouriteFoodRepository.save(favouriteFoods);
        };
    }

    @Bean(name = "orders-configuration")
    @DependsOn({"users-configuration", "addresses-configuration"})
    CommandLineRunner addDefaultOrders(OrdersRepository ordersRepository, UsersRepository usersRepository) {
        return args -> {

            Orders orders = new Orders();

            orders.setUser(usersRepository.findUsereById(1L));
            orders.setAddress(usersRepository.findUsereById(1L).getAddress());
            orders.setTotalPrice(30.5);

            ordersRepository.save(orders);
        };
    }

    @Bean(name = "foods-in-orders-configuration")
    @DependsOn({"orders-configuration", "food-configuration"})
    CommandLineRunner addDefaultFoodsInOrders(FoodsInOrdersRepository foodsInOrdersRepository) {
        return args -> {
            FoodsInOrders foodsInOrders = new FoodsInOrders();
            foodsInOrders.setId(new FoodsInOrdersKeyBuilder().addOrderId(1L).addFoodId(1L).build());
            foodsInOrders.setHowMany(3L);

            foodsInOrdersRepository.save(foodsInOrders);
        };
    }



}
