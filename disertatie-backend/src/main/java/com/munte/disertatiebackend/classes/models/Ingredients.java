package com.munte.disertatiebackend.classes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// an ingredient can be assigned to multiple foods and the foods can have multiple ingredients
@Entity
@Table(name = "INGREDIENTS")
public class Ingredients {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "ingredient")
    private Set<FoodIngredients> ingredientsInFood = new HashSet<>();

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

    public Set<FoodIngredients> getIngredientsInFood() {
        return ingredientsInFood;
    }

    public void setIngredientsInFood(Set<FoodIngredients> ingredientsInFood) {
        this.ingredientsInFood = ingredientsInFood;
    }
}
