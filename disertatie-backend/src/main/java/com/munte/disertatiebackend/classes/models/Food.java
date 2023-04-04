package com.munte.disertatiebackend.classes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.munte.disertatiebackend.classes.models.manytomany.FavouriteFoods;
import com.munte.disertatiebackend.classes.models.manytomany.FoodIngredients;
import com.munte.disertatiebackend.classes.models.manytomany.FoodTags;
import com.munte.disertatiebackend.classes.models.manytomany.FoodsInOrders;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// it can have multiple tags
// it can have multiple ingredients
@Entity
@Table(name = "FOOD")
public class Food {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "imageURL")
    private String imageURL;
    @Column(name = "price")
    private Double price;

    @JsonIgnore
    @OneToMany(mappedBy = "food")
    private Set<FavouriteFoods> userFavouriteFoods = new HashSet<>();

    @OneToMany(mappedBy = "food")
    private Set<FoodIngredients> foodIngredients = new HashSet<>();

    @OneToMany(mappedBy = "food")
    private Set<FoodTags> foodTags = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "food")
    private Set<FoodsInOrders> foodsInOrders = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<FavouriteFoods> getUserFavouriteFoods() {
        return userFavouriteFoods;
    }

    public Set<FoodIngredients> getFoodIngredients() {
        return foodIngredients;
    }

    public Set<FoodTags> getFoodTags() {
        return foodTags;
    }

    public Set<FoodsInOrders> getFoodsInOrders() {
        return foodsInOrders;
    }

    public void setUserFavouriteFoods(Set<FavouriteFoods> userFavouriteFoods) {
        this.userFavouriteFoods = userFavouriteFoods;
    }

    public void setFoodIngredients(Set<FoodIngredients> foodIngredients) {
        this.foodIngredients = foodIngredients;
    }

    public void setFoodTags(Set<FoodTags> foodTags) {
        this.foodTags = foodTags;
    }

    public void setFoodsInOrders(Set<FoodsInOrders> foodsInOrders) {
        this.foodsInOrders = foodsInOrders;
    }
}
