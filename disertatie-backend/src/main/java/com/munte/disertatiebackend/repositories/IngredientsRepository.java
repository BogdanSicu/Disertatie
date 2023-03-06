package com.munte.disertatiebackend.repositories;

import com.munte.disertatiebackend.classes.models.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {
}
