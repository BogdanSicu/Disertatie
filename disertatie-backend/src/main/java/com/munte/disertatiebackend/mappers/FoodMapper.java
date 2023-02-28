package com.munte.disertatiebackend.mappers;

import com.munte.disertatiebackend.classes.Food;
import com.munte.disertatiebackend.dtos.FoodDTO;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FoodMapper {

    public FoodMapper() {
    }

    public FoodDTO modelToDTO(Food food){
        FoodDTO foodDTO = new FoodDTO();

        foodDTO.setName(food.getName());
        foodDTO.setFavorite(food.isFavorite());
        foodDTO.setPrice(food.getPrice());
        foodDTO.setStars(food.getStars());
        foodDTO.setTags(food.getTags());

        File file =  new File(food.getImageUrl());
        foodDTO.setImage(file);

        return foodDTO;
    }
}
