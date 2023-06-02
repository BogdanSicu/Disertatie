package com.munte.disertatiebackend.repositories;

import com.munte.disertatiebackend.classes.dtos.ChartData;
import com.munte.disertatiebackend.classes.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findByName(String name);

    @Query(value = "SELECT food.name as foodName, SUM(food_in_orders.how_many) as foodQuantity FROM public.food_in_orders, public.food\n" +
            "WHERE food_in_orders.food_id = food.id\n" +
            "GROUP BY food.name\n" +
            "ORDER BY foodQuantity DESC\n" +
            "LIMIT 10", nativeQuery = true)
    List<ChartData> getChartData();
}
