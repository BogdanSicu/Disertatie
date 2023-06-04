package com.munte.disertatiebackend.configurations;

import com.munte.disertatiebackend.classes.models.*;
import com.munte.disertatiebackend.classes.models.addresses.Addresses;
import com.munte.disertatiebackend.classes.models.addresses.AddressesBuilder;
import com.munte.disertatiebackend.classes.models.foods.Food;
import com.munte.disertatiebackend.classes.models.foods.FoodBuilder;
import com.munte.disertatiebackend.classes.models.manytomany.FoodsInOrders;
import com.munte.disertatiebackend.classes.models.manytomany.compositekeys.favouritefoodskey.FavouriteFoodsKeyBuilder;
import com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodingredientskey.FoodIngredientsKeyBuilder;
import com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodsinorders.FoodsInOrdersKeyBuilder;
import com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodtagskey.FoodTagsKeyBuilder;
import com.munte.disertatiebackend.classes.models.manytomany.FavouriteFoods;
import com.munte.disertatiebackend.classes.models.manytomany.FoodIngredients;
import com.munte.disertatiebackend.classes.models.manytomany.FoodTags;
import com.munte.disertatiebackend.classes.models.orders.Orders;
import com.munte.disertatiebackend.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Configuration
public class DefaultDbDataConfiguration {

    @Bean(name = "food-configuration")
    CommandLineRunner addDefaultFood(FoodRepository foodRepository) {
        return args -> {

            List<Food> foodList = new LinkedList<>(Arrays.asList(
//                      pizza
                    new FoodBuilder()
                            .addName("Pizza All Cheese")
                            .addImage("pizza_all_cheese.png")
                            .addPrice(25.00)
                            .addCookingTime(35L)
                            .build(),
                    new FoodBuilder()
                            .addName("Pizza Argentina")
                            .addImage("pizza_argentina.png")
                            .addPrice(30.50)
                            .addCookingTime(40L)
                            .build(),
                    new FoodBuilder()
                            .addName("Pizza Carnivora")
                            .addImage("pizza_carnivor.png")
                            .addPrice(35.00)
                            .addCookingTime(40L)
                            .build(),
                    new FoodBuilder()
                            .addName("Pizza Classic")
                            .addImage("pizza_clasic.png")
                            .addPrice(32.00)
                            .addCookingTime(45L)
                            .build(),
                    new FoodBuilder()
                            .addName("Pizza Double Pepperoni")
                            .addImage("pizza_double_pepperoni.png")
                            .addPrice(37.00)
                            .addCookingTime(40L)
                            .build(),
                    new FoodBuilder()
                            .addName("Pizza Rustic")
                            .addImage("pizza_rustic.png")
                            .addPrice(34.50)
                            .addCookingTime(40L)
                            .build(),
                    new FoodBuilder()
                            .addName("Pizza BBQ")
                            .addImage("pizza_bbq.png")
                            .addPrice(40.00)
                            .addCookingTime(40L)
                            .build(),
                    new FoodBuilder()
                            .addName("Pizza Light")
                            .addImage("pizza_light.png")
                            .addPrice(30.00)
                            .addCookingTime(35L)
                            .build(),
//                      paste
                    new FoodBuilder()
                            .addName("Paste Bolognese")
                            .addImage("paste_bolognese.png")
                            .addPrice(25.00)
                            .addCookingTime(25L)
                            .build(),
                    new FoodBuilder()
                            .addName("Paste Carbonara")
                            .addImage("paste_carbonara.png")
                            .addPrice(27.50)
                            .addCookingTime(25L)
                            .build(),
                    new FoodBuilder()
                            .addName("Paste Quattro Formaggi")
                            .addImage("paste_quattro_formaggi.png")
                            .addPrice(26.50)
                            .addCookingTime(25L)
                            .build(),
                    new FoodBuilder()
                            .addName("Paste Verdurette")
                            .addImage("paste_verdurette.png")
                            .addPrice(25.50)
                            .addCookingTime(25L)
                            .build(),
//                      desert
                    new FoodBuilder()
                            .addName("Desert Cup Ciocolata & Capsuni")
                            .addImage("desert_cup_ciocolata_si_capsuni.png")
                            .addPrice(12.50)
                            .addCookingTime(0L)
                            .build(),
                    new FoodBuilder()
                            .addName("Desert Cup Fistic & Ciocolata")
                            .addImage("desert_cup_fistic_si_ciocolata.png")
                            .addPrice(12.50)
                            .addCookingTime(0L)
                            .build(),
                    new FoodBuilder()
                            .addName("Desert Cup Visine")
                            .addImage("desert_cup_visine.png")
                            .addPrice(11.00)
                            .addCookingTime(0L)
                            .build(),
//                      bauturi
                    new FoodBuilder()
                            .addName("Cappy Lemonade")
                            .addImage("bautura_cappy_lemonade.png")
                            .addPrice(7.00)
                            .addCookingTime(0L)
                            .build(),
                    new FoodBuilder()
                            .addName("Bere Ciuc")
                            .addImage("bautura_ciuc.png")
                            .addPrice(7.00)
                            .addCookingTime(0L)
                            .build(),
                    new FoodBuilder()
                            .addName("Bere Heineken")
                            .addImage("bautura_heineken.png")
                            .addPrice(7.00)
                            .addCookingTime(0L)
                            .build(),
//                      sosuri
                    new FoodBuilder()
                            .addName("Sos BBQ")
                            .addImage("sos_bbq.png")
                            .addPrice(3.00)
                            .addCookingTime(0L)
                            .build(),
                    new FoodBuilder()
                            .addName("Sos Pizza")
                            .addImage("sos_pizza.png")
                            .addPrice(3.00)
                            .addCookingTime(0L)
                            .build(),
                    new FoodBuilder()
                            .addName("Sos Salsa")
                            .addImage("sos_salsa.png")
                            .addPrice(3.00)
                            .addCookingTime(0L)
                            .build(),
                    new FoodBuilder()
                            .addName("Sos Sweet Chili")
                            .addImage("sos_sweet_chili.png")
                            .addPrice(3.00)
                            .addCookingTime(0L)
                            .build()
            ));

            for(Food food : foodList) {
                foodRepository.save(food);
            }

        };
    }

    @Bean(name = "tags-configuration")
    CommandLineRunner addDefaultTags(TagsRepository tagsRepository) {
        return args -> {
            Tags pizza =  new Tags();
            pizza.setName("Pizza");

            Tags desert = new Tags();
            desert.setName("Desert");

            Tags bautura = new Tags();
            bautura.setName("Bautura");

            Tags sos = new Tags();
            sos.setName("Sos");

            Tags paste = new Tags();
            paste.setName("Paste");

            Tags vegetarian = new Tags();
            vegetarian.setName("Vegetarian");

            Tags carne = new Tags();
            carne.setName("Carne");

            Tags iute = new Tags();
            iute.setName("Iute");

            Tags dulce = new Tags();
            dulce.setName("Dulce");

            Tags sarat = new Tags();
            sarat.setName("Sarat");

            tagsRepository.save(pizza);
            tagsRepository.save(desert);
            tagsRepository.save(bautura);
            tagsRepository.save(sos);
            tagsRepository.save(paste);
            tagsRepository.save(vegetarian);
            tagsRepository.save(carne);
            tagsRepository.save(iute);
            tagsRepository.save(sarat);
            tagsRepository.save(dulce);
        };
    }

    @Bean(name = "ingredients-configuration")
    CommandLineRunner addDefaultIngredients(IngredientsRepository ingredientsRepository) {
        return args -> {
            Ingredients branza = new Ingredients();
            branza.setName("Branza");
            Ingredients sunca = new Ingredients();
            sunca.setName("Sunca");
            Ingredients salam = new Ingredients();
            salam.setName("Salam");
            Ingredients ardei = new Ingredients();
            ardei.setName("Ardei");
            Ingredients carneDeVita = new Ingredients();
            carneDeVita.setName("Carne de Vita");
            Ingredients carnati = new Ingredients();
            carnati.setName("Carnati");
            Ingredients cascaval = new Ingredients();
            cascaval.setName("Cascaval");
            Ingredients visine = new Ingredients();
            visine.setName("Visine");
            Ingredients ciocolata = new Ingredients();
            ciocolata.setName("Ciocolata");
            Ingredients ceapa = new Ingredients();
            ceapa.setName("Ceapa");
            Ingredients sosDeRosii = new Ingredients();
            sosDeRosii.setName("Sos de Rosii");
            Ingredients sosBBQ = new Ingredients();
            sosBBQ.setName("Sos BBQ");
            Ingredients pui = new Ingredients();
            pui.setName("Carne de Pui");
            Ingredients masline = new Ingredients();
            masline.setName("Masline");
            Ingredients ciuperci = new Ingredients();
            ciuperci.setName("Ciuperci");
            Ingredients bacon = new Ingredients();
            bacon.setName("Bacon");
            Ingredients uleiMasline = new Ingredients();
            uleiMasline.setName("Ulei de Masline");
            Ingredients piper = new Ingredients();
            piper.setName("Piper");
            Ingredients frisca = new Ingredients();
            frisca.setName("Frisca");
            Ingredients fistic = new Ingredients();
            fistic.setName("Fistic");
            Ingredients capsuni = new Ingredients();
            capsuni.setName("Capsuni");
            Ingredients porumb = new Ingredients();
            porumb.setName("Porumb");

            ingredientsRepository.save(branza);
            ingredientsRepository.save(sunca);
            ingredientsRepository.save(salam);
            ingredientsRepository.save(ardei);
            ingredientsRepository.save(carneDeVita);
            ingredientsRepository.save(carnati);
            ingredientsRepository.save(cascaval);
            ingredientsRepository.save(visine);
            ingredientsRepository.save(ciocolata);
            ingredientsRepository.save(sosDeRosii);
            ingredientsRepository.save(sosBBQ);
            ingredientsRepository.save(pui);
            ingredientsRepository.save(masline);
            ingredientsRepository.save(ciuperci);
            ingredientsRepository.save(bacon);
            ingredientsRepository.save(uleiMasline);
            ingredientsRepository.save(piper);
            ingredientsRepository.save(frisca);
            ingredientsRepository.save(fistic);
            ingredientsRepository.save(capsuni);
            ingredientsRepository.save(porumb);
            ingredientsRepository.save(ceapa);

        };
    }

    @Bean(name = "food-ingredients-relation")
    @DependsOn({"ingredients-configuration", "food-configuration"})
    CommandLineRunner addManyToManyDataForFoodAndIngredients(FoodIngredientsRepository foodIngredientsRepository, FoodRepository foodRepository, IngredientsRepository ingredientsRepository) {
        return args -> {
//            all_cheese
            FoodIngredients pizza_all_cheese_ingredient_branza = new FoodIngredients();
            pizza_all_cheese_ingredient_branza.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Branza").getId()).addFoodId(foodRepository.findByName("Pizza All Cheese").getId()).build());
            foodIngredientsRepository.save(pizza_all_cheese_ingredient_branza);

            FoodIngredients pizza_all_cheese_ingredient_cascaval = new FoodIngredients();
            pizza_all_cheese_ingredient_cascaval.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Cascaval").getId()).addFoodId(foodRepository.findByName("Pizza All Cheese").getId()).build());
            foodIngredientsRepository.save(pizza_all_cheese_ingredient_cascaval);

            FoodIngredients pizza_all_cheese_ingredient_sosDeRosii = new FoodIngredients();
            pizza_all_cheese_ingredient_sosDeRosii.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Sos de Rosii").getId()).addFoodId(foodRepository.findByName("Pizza All Cheese").getId()).build());
            foodIngredientsRepository.save(pizza_all_cheese_ingredient_sosDeRosii);

//            argentina
            FoodIngredients pizza_argentina_ingredient_carneDeVita = new FoodIngredients();
            pizza_argentina_ingredient_carneDeVita.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Carne de Vita").getId()).addFoodId(foodRepository.findByName("Pizza Argentina").getId()).build());
            foodIngredientsRepository.save(pizza_argentina_ingredient_carneDeVita);

            FoodIngredients pizza_argentina_ingredient_ardei = new FoodIngredients();
            pizza_argentina_ingredient_ardei.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Ardei").getId()).addFoodId(foodRepository.findByName("Pizza Argentina").getId()).build());
            foodIngredientsRepository.save(pizza_argentina_ingredient_ardei);

            FoodIngredients pizza_argentina_ingredient_ceapa = new FoodIngredients();
            pizza_argentina_ingredient_ceapa.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Ceapa").getId()).addFoodId(foodRepository.findByName("Pizza Argentina").getId()).build());
            foodIngredientsRepository.save(pizza_argentina_ingredient_ceapa);

            FoodIngredients pizza_argentina_ingredient_sosDeRosii = new FoodIngredients();
            pizza_argentina_ingredient_sosDeRosii.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Sos de Rosii").getId()).addFoodId(foodRepository.findByName("Pizza Argentina").getId()).build());
            foodIngredientsRepository.save(pizza_argentina_ingredient_sosDeRosii);

            FoodIngredients pizza_argentina_ingredient_cascaval = new FoodIngredients();
            pizza_argentina_ingredient_cascaval.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Cascaval").getId()).addFoodId(foodRepository.findByName("Pizza Argentina").getId()).build());
            foodIngredientsRepository.save(pizza_argentina_ingredient_cascaval);

//            carnivora
            FoodIngredients pizza_carnivora_ingredient_sosDeRosii = new FoodIngredients();
            pizza_carnivora_ingredient_sosDeRosii.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Sos de Rosii").getId()).addFoodId(foodRepository.findByName("Pizza Carnivora").getId()).build());
            foodIngredientsRepository.save(pizza_carnivora_ingredient_sosDeRosii);

            FoodIngredients pizza_carnivora_ingredient_salam = new FoodIngredients();
            pizza_carnivora_ingredient_salam.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Salam").getId()).addFoodId(foodRepository.findByName("Pizza Carnivora").getId()).build());
            foodIngredientsRepository.save(pizza_carnivora_ingredient_salam);

            FoodIngredients pizza_carnivora_ingredient_cascaval = new FoodIngredients();
            pizza_carnivora_ingredient_cascaval.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Cascaval").getId()).addFoodId(foodRepository.findByName("Pizza Carnivora").getId()).build());
            foodIngredientsRepository.save(pizza_carnivora_ingredient_cascaval);

            FoodIngredients pizza_carnivora_ingredient_carnati = new FoodIngredients();
            pizza_carnivora_ingredient_carnati.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Carnati").getId()).addFoodId(foodRepository.findByName("Pizza Carnivora").getId()).build());
            foodIngredientsRepository.save(pizza_carnivora_ingredient_carnati);

            FoodIngredients pizza_carnivora_ingredient_sunca = new FoodIngredients();
            pizza_carnivora_ingredient_sunca.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Sunca").getId()).addFoodId(foodRepository.findByName("Pizza Carnivora").getId()).build());
            foodIngredientsRepository.save(pizza_carnivora_ingredient_sunca);

            FoodIngredients pizza_carnivora_ingredient_pui = new FoodIngredients();
            pizza_carnivora_ingredient_pui.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Carne de Pui").getId()).addFoodId(foodRepository.findByName("Pizza Carnivora").getId()).build());
            foodIngredientsRepository.save(pizza_carnivora_ingredient_pui);

//            classic
            FoodIngredients pizza_classic_ingredient_sosDeRosii = new FoodIngredients();
            pizza_classic_ingredient_sosDeRosii.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Sos de Rosii").getId()).addFoodId(foodRepository.findByName("Pizza Classic").getId()).build());
            foodIngredientsRepository.save(pizza_classic_ingredient_sosDeRosii);

            FoodIngredients pizza_classic_ingredient_sunca = new FoodIngredients();
            pizza_classic_ingredient_sunca.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Sunca").getId()).addFoodId(foodRepository.findByName("Pizza Classic").getId()).build());
            foodIngredientsRepository.save(pizza_classic_ingredient_sunca);

            FoodIngredients pizza_classic_ingredient_masline = new FoodIngredients();
            pizza_classic_ingredient_masline.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Masline").getId()).addFoodId(foodRepository.findByName("Pizza Classic").getId()).build());
            foodIngredientsRepository.save(pizza_classic_ingredient_masline);

//            paste bolognese
            FoodIngredients paste_bolognese_vita = new FoodIngredients();
            paste_bolognese_vita.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Carne de Vita").getId()).addFoodId(foodRepository.findByName("Paste Bolognese").getId()).build());
            foodIngredientsRepository.save(paste_bolognese_vita);

            FoodIngredients paste_bolognese_sosDeRosii = new FoodIngredients();
            paste_bolognese_sosDeRosii.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Sos de Rosii").getId()).addFoodId(foodRepository.findByName("Paste Bolognese").getId()).build());
            foodIngredientsRepository.save(paste_bolognese_sosDeRosii);

            FoodIngredients paste_bolognese_cascaval = new FoodIngredients();
            paste_bolognese_cascaval.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Cascaval").getId()).addFoodId(foodRepository.findByName("Paste Bolognese").getId()).build());
            foodIngredientsRepository.save(paste_bolognese_cascaval);

            FoodIngredients paste_bolognese_piper = new FoodIngredients();
            paste_bolognese_piper.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Piper").getId()).addFoodId(foodRepository.findByName("Paste Bolognese").getId()).build());
            foodIngredientsRepository.save(paste_bolognese_piper);

//            Desert Cup Fistic & Ciocolata
            FoodIngredients desert_cup_fistic_si_ciocolata1 = new FoodIngredients();
            desert_cup_fistic_si_ciocolata1.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Ciocolata").getId()).addFoodId(foodRepository.findByName("Desert Cup Fistic & Ciocolata").getId()).build());
            foodIngredientsRepository.save(desert_cup_fistic_si_ciocolata1);

            FoodIngredients desert_cup_fistic1_si_ciocolata = new FoodIngredients();
            desert_cup_fistic1_si_ciocolata.setId(new FoodIngredientsKeyBuilder().addIngredientId(ingredientsRepository.findByName("Fistic").getId()).addFoodId(foodRepository.findByName("Desert Cup Fistic & Ciocolata").getId()).build());
            foodIngredientsRepository.save(desert_cup_fistic1_si_ciocolata);

        };
    }

    @Bean(name = "food-tags-relation")
    @DependsOn({"tags-configuration", "food-configuration"})
    CommandLineRunner addManyToManyDataForFoodAndTags(FoodTagsRepository foodTagsRepository, FoodRepository foodRepository, TagsRepository tagsRepository) {
        return args -> {
//            all cheese
            FoodTags pizza_all_cheese_tag_pizza = new FoodTags();
            pizza_all_cheese_tag_pizza.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza All Cheese").getId()).addTagsId(tagsRepository.findByName("Pizza").getId()).build());
            foodTagsRepository.save(pizza_all_cheese_tag_pizza);

            FoodTags pizza_all_cheese_tag_vegetarian = new FoodTags();
            pizza_all_cheese_tag_vegetarian.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza All Cheese").getId()).addTagsId(tagsRepository.findByName("Vegetarian").getId()).build());
            foodTagsRepository.save(pizza_all_cheese_tag_vegetarian);

            FoodTags pizza_all_cheese_tag_sarat = new FoodTags();
            pizza_all_cheese_tag_sarat.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza All Cheese").getId()).addTagsId(tagsRepository.findByName("Sarat").getId()).build());
            foodTagsRepository.save(pizza_all_cheese_tag_sarat);

//            argentina
            FoodTags pizza_argentina_tag_pizza = new FoodTags();
            pizza_argentina_tag_pizza.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza Argentina").getId()).addTagsId(tagsRepository.findByName("Pizza").getId()).build());
            foodTagsRepository.save(pizza_argentina_tag_pizza);

            FoodTags pizza_argentina_tag_carne = new FoodTags();
            pizza_argentina_tag_carne.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza Argentina").getId()).addTagsId(tagsRepository.findByName("Carne").getId()).build());
            foodTagsRepository.save(pizza_argentina_tag_carne);

//            carnivora
            FoodTags pizza_carnivora_tag_pizza = new FoodTags();
            pizza_carnivora_tag_pizza.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza Carnivora").getId()).addTagsId(tagsRepository.findByName("Pizza").getId()).build());
            foodTagsRepository.save(pizza_carnivora_tag_pizza);

            FoodTags pizza_carnivora_tag_carne = new FoodTags();
            pizza_carnivora_tag_carne.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza Carnivora").getId()).addTagsId(tagsRepository.findByName("Carne").getId()).build());
            foodTagsRepository.save(pizza_carnivora_tag_carne);

//            classic
            FoodTags pizza_classic_tag_pizza = new FoodTags();
            pizza_classic_tag_pizza.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza Classic").getId()).addTagsId(tagsRepository.findByName("Pizza").getId()).build());
            foodTagsRepository.save(pizza_classic_tag_pizza);

            FoodTags pizza_classic_tag_carne = new FoodTags();
            pizza_classic_tag_carne.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza Classic").getId()).addTagsId(tagsRepository.findByName("Carne").getId()).build());
            foodTagsRepository.save(pizza_classic_tag_carne);

            FoodTags pizza_classic_tag_sarat = new FoodTags();
            pizza_classic_tag_sarat.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza Classic").getId()).addTagsId(tagsRepository.findByName("Sarat").getId()).build());
            foodTagsRepository.save(pizza_classic_tag_sarat);

//            double pepperoni
            FoodTags pizza_double_pepperoni_tag_pizza = new FoodTags();
            pizza_double_pepperoni_tag_pizza.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza Double Pepperoni").getId()).addTagsId(tagsRepository.findByName("Pizza").getId()).build());
            foodTagsRepository.save(pizza_double_pepperoni_tag_pizza);

            FoodTags pizza_double_pepperoni_tag_carne = new FoodTags();
            pizza_double_pepperoni_tag_carne.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza Double Pepperoni").getId()).addTagsId(tagsRepository.findByName("Carne").getId()).build());
            foodTagsRepository.save(pizza_double_pepperoni_tag_carne);

            FoodTags pizza_double_pepperoni_tag_sarat = new FoodTags();
            pizza_double_pepperoni_tag_sarat.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza Double Pepperoni").getId()).addTagsId(tagsRepository.findByName("Sarat").getId()).build());
            foodTagsRepository.save(pizza_double_pepperoni_tag_sarat);

//            rustic
            FoodTags pizza_rustic_tag_pizza = new FoodTags();
            pizza_rustic_tag_pizza.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza Rustic").getId()).addTagsId(tagsRepository.findByName("Pizza").getId()).build());
            foodTagsRepository.save(pizza_rustic_tag_pizza);

            FoodTags pizza_rustic_tag_carne = new FoodTags();
            pizza_rustic_tag_carne.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza Rustic").getId()).addTagsId(tagsRepository.findByName("Carne").getId()).build());
            foodTagsRepository.save(pizza_rustic_tag_carne);

//            pizza bbq
            FoodTags pizza_bbq_tag_pizza = new FoodTags();
            pizza_bbq_tag_pizza.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza BBQ").getId()).addTagsId(tagsRepository.findByName("Pizza").getId()).build());
            foodTagsRepository.save(pizza_bbq_tag_pizza);

            FoodTags pizza_bbq_tag_carne = new FoodTags();
            pizza_bbq_tag_carne.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza BBQ").getId()).addTagsId(tagsRepository.findByName("Carne").getId()).build());
            foodTagsRepository.save(pizza_bbq_tag_carne);

//            light
            FoodTags pizza_light_tag_pizza = new FoodTags();
            pizza_light_tag_pizza.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza Light").getId()).addTagsId(tagsRepository.findByName("Pizza").getId()).build());
            foodTagsRepository.save(pizza_light_tag_pizza);

            FoodTags pizza_light_tag_vegetarian = new FoodTags();
            pizza_light_tag_vegetarian.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Pizza Light").getId()).addTagsId(tagsRepository.findByName("Vegetarian").getId()).build());
            foodTagsRepository.save(pizza_light_tag_vegetarian);

//            paste bolognese
            FoodTags paste_bolognese_tag_paste = new FoodTags();
            paste_bolognese_tag_paste.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Paste Bolognese").getId()).addTagsId(tagsRepository.findByName("Paste").getId()).build());
            foodTagsRepository.save(paste_bolognese_tag_paste);

            FoodTags paste_bolognese_tag_carne = new FoodTags();
            paste_bolognese_tag_carne.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Paste Bolognese").getId()).addTagsId(tagsRepository.findByName("Carne").getId()).build());
            foodTagsRepository.save(paste_bolognese_tag_carne);

//            paste carbonara
            FoodTags paste_carbonara_tag_paste = new FoodTags();
            paste_carbonara_tag_paste.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Paste Carbonara").getId()).addTagsId(tagsRepository.findByName("Paste").getId()).build());
            foodTagsRepository.save(paste_carbonara_tag_paste);

            FoodTags paste_carbonara_tag_carne = new FoodTags();
            paste_carbonara_tag_carne.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Paste Carbonara").getId()).addTagsId(tagsRepository.findByName("Carne").getId()).build());
            foodTagsRepository.save(paste_carbonara_tag_carne);

//            paste quattro formaggi
            FoodTags paste_quattro_formaggi_tag_paste = new FoodTags();
            paste_quattro_formaggi_tag_paste.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Paste Quattro Formaggi").getId()).addTagsId(tagsRepository.findByName("Paste").getId()).build());
            foodTagsRepository.save(paste_quattro_formaggi_tag_paste);

            FoodTags paste_quattro_formaggi_tag_vegetarian = new FoodTags();
            paste_quattro_formaggi_tag_vegetarian.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Paste Quattro Formaggi").getId()).addTagsId(tagsRepository.findByName("Vegetarian").getId()).build());
            foodTagsRepository.save(paste_quattro_formaggi_tag_vegetarian);

//            paste verdurette
            FoodTags paste_verdurette_tag_paste = new FoodTags();
            paste_verdurette_tag_paste.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Paste Verdurette").getId()).addTagsId(tagsRepository.findByName("Paste").getId()).build());
            foodTagsRepository.save(paste_verdurette_tag_paste);

            FoodTags paste_verdurette_tag_vegetarian = new FoodTags();
            paste_verdurette_tag_vegetarian.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Paste Verdurette").getId()).addTagsId(tagsRepository.findByName("Vegetarian").getId()).build());
            foodTagsRepository.save(paste_verdurette_tag_vegetarian);

//            cup ciocolata & capsuni
            FoodTags desert_cup_ciocolata_si_capsuni_tag_desert = new FoodTags();
            desert_cup_ciocolata_si_capsuni_tag_desert.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Desert Cup Ciocolata & Capsuni").getId()).addTagsId(tagsRepository.findByName("Desert").getId()).build());
            foodTagsRepository.save(desert_cup_ciocolata_si_capsuni_tag_desert);

            FoodTags desert_cup_ciocolata_si_capsuni_tag_dulce = new FoodTags();
            desert_cup_ciocolata_si_capsuni_tag_dulce.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Desert Cup Ciocolata & Capsuni").getId()).addTagsId(tagsRepository.findByName("Dulce").getId()).build());
            foodTagsRepository.save(desert_cup_ciocolata_si_capsuni_tag_dulce);

//            cup fistic & ciocolata
            FoodTags desert_cup_ciocolata_si_fistic_tag_desert = new FoodTags();
            desert_cup_ciocolata_si_fistic_tag_desert.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Desert Cup Fistic & Ciocolata").getId()).addTagsId(tagsRepository.findByName("Desert").getId()).build());
            foodTagsRepository.save(desert_cup_ciocolata_si_fistic_tag_desert);

            FoodTags desert_cup_ciocolata_si_fistic_tag_dulce = new FoodTags();
            desert_cup_ciocolata_si_fistic_tag_dulce.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Desert Cup Fistic & Ciocolata").getId()).addTagsId(tagsRepository.findByName("Dulce").getId()).build());
            foodTagsRepository.save(desert_cup_ciocolata_si_fistic_tag_dulce);

//            cup visine
            FoodTags desert_cup_visine_tag_desert = new FoodTags();
            desert_cup_visine_tag_desert.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Desert Cup Visine").getId()).addTagsId(tagsRepository.findByName("Desert").getId()).build());
            foodTagsRepository.save(desert_cup_visine_tag_desert);

            FoodTags desert_cup_visine_tag_dulce = new FoodTags();
            desert_cup_visine_tag_dulce.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Desert Cup Visine").getId()).addTagsId(tagsRepository.findByName("Dulce").getId()).build());
            foodTagsRepository.save(desert_cup_visine_tag_dulce);

//            Cappy Lemonade
            FoodTags bautura_cappy_lemonade_tag_bautura = new FoodTags();
            bautura_cappy_lemonade_tag_bautura.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Cappy Lemonade").getId()).addTagsId(tagsRepository.findByName("Bautura").getId()).build());
            foodTagsRepository.save(bautura_cappy_lemonade_tag_bautura);

//            ciuc
            FoodTags bautura_ciuc_tag_bautura = new FoodTags();
            bautura_ciuc_tag_bautura.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Bere Ciuc").getId()).addTagsId(tagsRepository.findByName("Bautura").getId()).build());
            foodTagsRepository.save(bautura_ciuc_tag_bautura);

//            heineken
            FoodTags bautura_heinekent_tag_bautura = new FoodTags();
            bautura_heinekent_tag_bautura.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Bere Heineken").getId()).addTagsId(tagsRepository.findByName("Bautura").getId()).build());
            foodTagsRepository.save(bautura_heinekent_tag_bautura);

//            sos BBQ
            FoodTags sos_bbq_tag_sos = new FoodTags();
            sos_bbq_tag_sos.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Sos BBQ").getId()).addTagsId(tagsRepository.findByName("Sos").getId()).build());
            foodTagsRepository.save(sos_bbq_tag_sos);

//            sos pizza
            FoodTags sos_pizza_tag_sos = new FoodTags();
            sos_pizza_tag_sos.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Sos Pizza").getId()).addTagsId(tagsRepository.findByName("Sos").getId()).build());
            foodTagsRepository.save(sos_pizza_tag_sos);

            FoodTags sos_pizza_tag_dulce = new FoodTags();
            sos_pizza_tag_dulce.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Sos Pizza").getId()).addTagsId(tagsRepository.findByName("Dulce").getId()).build());
            foodTagsRepository.save(sos_pizza_tag_dulce);

//            sos salsa
            FoodTags sos_salsa_tag_sos = new FoodTags();
            sos_salsa_tag_sos.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Sos Salsa").getId()).addTagsId(tagsRepository.findByName("Sos").getId()).build());
            foodTagsRepository.save(sos_salsa_tag_sos);

            FoodTags sos_salsa_tag_iute = new FoodTags();
            sos_salsa_tag_iute.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Sos Salsa").getId()).addTagsId(tagsRepository.findByName("Iute").getId()).build());
            foodTagsRepository.save(sos_salsa_tag_iute);

//            sos sweet chili
            FoodTags sos_sweet_chili_tag_sos = new FoodTags();
            sos_sweet_chili_tag_sos.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Sos Sweet Chili").getId()).addTagsId(tagsRepository.findByName("Sos").getId()).build());
            foodTagsRepository.save(sos_sweet_chili_tag_sos);

            FoodTags sos_sweet_chili_tag_iute = new FoodTags();
            sos_sweet_chili_tag_iute.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Sos Sweet Chili").getId()).addTagsId(tagsRepository.findByName("Iute").getId()).build());
            foodTagsRepository.save(sos_sweet_chili_tag_iute);

            FoodTags sos_sweet_chili_tag_dulce = new FoodTags();
            sos_sweet_chili_tag_dulce.setId(new FoodTagsKeyBuilder().addFoodId(foodRepository.findByName("Sos Sweet Chili").getId()).addTagsId(tagsRepository.findByName("Dulce").getId()).build());
            foodTagsRepository.save(sos_sweet_chili_tag_dulce);
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
            Addresses address1 = new AddressesBuilder().addCountry("Romania")
//                    .addCounty("Bucharest")
                    .addCity("Bucharest").addStreet("Bd. Timisoara")
                    .addStreetNumber(89L).addBuilding("C 1.3")
//                    .addStaircase("A")
                    .addRoom(10L).build();

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

//            admin.setAddress(addressesRepository.findAll().stream().filter(addresses -> addresses.getCity().equals("Bucharest") && addresses.getBuilding().equals("C 1.3") && addresses.getRoom() == 10L).toList().get(0));
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
    CommandLineRunner addDefaultOrders(OrdersRepository ordersRepository, AddressesRepository addressesRepository) {
        return args -> {

            Orders orders = new Orders();
//
//            orders.setUser(usersRepository.findUserById(1L));
            orders.setAddress(addressesRepository.findAll().stream().filter(x -> x.getId().equals(1L)).toList().get(0));
            orders.setTotalPrice(75.00);
            ordersRepository.save(orders);


            Orders order2 =  new Orders();
            order2.setAddress(addressesRepository.findAll().stream().filter(x -> x.getId().equals(1L)).toList().get(0));
            order2.setUserName("Bogdan");
            order2.setMail("sicubogdan18@stud.ase.ro");
            order2.setPhoneNumber("0722222222");
            order2.setTotalPrice(1300.00);

            ordersRepository.save(order2);
        };
    }

    @Bean(name = "foods-in-orders-configuration")
    @DependsOn({"orders-configuration", "food-configuration"})
    CommandLineRunner addDefaultFoodsInOrders(FoodsInOrdersRepository foodsInOrdersRepository, FoodRepository foodRepository) {
        return args -> {
//            comanda 1
            FoodsInOrders foodsInOrders = new FoodsInOrders();
            foodsInOrders.setId(new FoodsInOrdersKeyBuilder().addOrderId(1L).addFoodId(foodRepository.findByName("Pizza All Cheese").getId()).build());
            foodsInOrders.setHowMany(3L);
            foodsInOrdersRepository.save(foodsInOrders);

//            comanda 2
            FoodsInOrders foodsInOrders2Argentina = new FoodsInOrders();
            foodsInOrders2Argentina.setId(new FoodsInOrdersKeyBuilder().addOrderId(2L).addFoodId(foodRepository.findByName("Pizza Argentina").getId()).build());
            foodsInOrders2Argentina.setHowMany(6L);

            FoodsInOrders foodsInOrders2PizzaCarnivora = new FoodsInOrders();
            foodsInOrders2PizzaCarnivora.setId(new FoodsInOrdersKeyBuilder().addOrderId(2L).addFoodId(foodRepository.findByName("Pizza Carnivora").getId()).build());
            foodsInOrders2PizzaCarnivora.setHowMany(3L);

            FoodsInOrders foodsInOrders2PizzaClassic = new FoodsInOrders();
            foodsInOrders2PizzaClassic.setId(new FoodsInOrdersKeyBuilder().addOrderId(2L).addFoodId(foodRepository.findByName("Pizza Classic").getId()).build());
            foodsInOrders2PizzaClassic.setHowMany(1L);

            FoodsInOrders foodsInOrders2PizzaDoublePepperoni = new FoodsInOrders();
            foodsInOrders2PizzaDoublePepperoni.setId(new FoodsInOrdersKeyBuilder().addOrderId(2L).addFoodId(foodRepository.findByName("Pizza Double Pepperoni").getId()).build());
            foodsInOrders2PizzaDoublePepperoni.setHowMany(6L);

            FoodsInOrders foodsInOrders2Rustic = new FoodsInOrders();
            foodsInOrders2Rustic.setId(new FoodsInOrdersKeyBuilder().addOrderId(2L).addFoodId(foodRepository.findByName("Pizza Rustic").getId()).build());
            foodsInOrders2Rustic.setHowMany(6L);

            FoodsInOrders foodsInOrders2PizzaBBQ = new FoodsInOrders();
            foodsInOrders2PizzaBBQ.setId(new FoodsInOrdersKeyBuilder().addOrderId(2L).addFoodId(foodRepository.findByName("Pizza BBQ").getId()).build());
            foodsInOrders2PizzaBBQ.setHowMany(2L);

            FoodsInOrders foodsInOrders2PizzaLight = new FoodsInOrders();
            foodsInOrders2PizzaLight.setId(new FoodsInOrdersKeyBuilder().addOrderId(2L).addFoodId(foodRepository.findByName("Pizza Light").getId()).build());
            foodsInOrders2PizzaLight.setHowMany(4L);

            FoodsInOrders foodsInOrders2PasteCarbonara = new FoodsInOrders();
            foodsInOrders2PasteCarbonara.setId(new FoodsInOrdersKeyBuilder().addOrderId(2L).addFoodId(foodRepository.findByName("Paste Carbonara").getId()).build());
            foodsInOrders2PasteCarbonara.setHowMany(5L);

            FoodsInOrders foodsInOrders2PasteBolognese = new FoodsInOrders();
            foodsInOrders2PasteBolognese.setId(new FoodsInOrdersKeyBuilder().addOrderId(2L).addFoodId(foodRepository.findByName("Paste Bolognese").getId()).build());
            foodsInOrders2PasteBolognese.setHowMany(8L);

            FoodsInOrders foodsInOrders2DesertCupVisine = new FoodsInOrders();
            foodsInOrders2DesertCupVisine.setId(new FoodsInOrdersKeyBuilder().addOrderId(2L).addFoodId(foodRepository.findByName("Desert Cup Visine").getId()).build());
            foodsInOrders2DesertCupVisine.setHowMany(2L);

            FoodsInOrders foodsInOrders2BauturaCiuc = new FoodsInOrders();
            foodsInOrders2BauturaCiuc.setId(new FoodsInOrdersKeyBuilder().addOrderId(2L).addFoodId(foodRepository.findByName("Bere Ciuc").getId()).build());
            foodsInOrders2BauturaCiuc.setHowMany(3L);

            FoodsInOrders foodsInOrders2DesertCupFisticSiCiocolata = new FoodsInOrders();
            foodsInOrders2DesertCupFisticSiCiocolata.setId(new FoodsInOrdersKeyBuilder().addOrderId(2L).addFoodId(foodRepository.findByName("Desert Cup Fistic & Ciocolata").getId()).build());
            foodsInOrders2DesertCupFisticSiCiocolata.setHowMany(4L);

            FoodsInOrders foodsInOrders2SosPizza = new FoodsInOrders();
            foodsInOrders2SosPizza.setId(new FoodsInOrdersKeyBuilder().addOrderId(2L).addFoodId(foodRepository.findByName("Sos Pizza").getId()).build());
            foodsInOrders2SosPizza.setHowMany(3L);


            foodsInOrdersRepository.save(foodsInOrders2Argentina);
            foodsInOrdersRepository.save(foodsInOrders2PizzaCarnivora);
            foodsInOrdersRepository.save(foodsInOrders2PizzaClassic);
            foodsInOrdersRepository.save(foodsInOrders2PizzaDoublePepperoni);
            foodsInOrdersRepository.save(foodsInOrders2Rustic);
            foodsInOrdersRepository.save(foodsInOrders2PizzaBBQ);
            foodsInOrdersRepository.save(foodsInOrders2PizzaLight);
            foodsInOrdersRepository.save(foodsInOrders2PasteCarbonara);
            foodsInOrdersRepository.save(foodsInOrders2PasteBolognese);
            foodsInOrdersRepository.save(foodsInOrders2DesertCupVisine);
            foodsInOrdersRepository.save(foodsInOrders2BauturaCiuc);
            foodsInOrdersRepository.save(foodsInOrders2DesertCupFisticSiCiocolata);
            foodsInOrdersRepository.save(foodsInOrders2SosPizza);

        };
    }



}
