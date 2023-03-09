package com.munte.disertatiebackend.repositories;

import com.munte.disertatiebackend.classes.models.manytomany.FoodsInOrders;
import com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodsinorders.FoodsInOrderKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodsInOrdersRepository extends JpaRepository<FoodsInOrders, FoodsInOrderKey> {
}
