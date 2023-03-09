package com.munte.disertatiebackend.repositories;

import com.munte.disertatiebackend.classes.models.FavouriteFoods;
import com.munte.disertatiebackend.classes.models.compositekeys.favouritefoodskey.FavouriteFoodsKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriteFoodRepository extends JpaRepository<FavouriteFoods, FavouriteFoodsKey> {
}
