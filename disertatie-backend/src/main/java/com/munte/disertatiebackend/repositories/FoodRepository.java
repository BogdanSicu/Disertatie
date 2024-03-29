package com.munte.disertatiebackend.repositories;

import com.munte.disertatiebackend.classes.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findByName(String name);
}
