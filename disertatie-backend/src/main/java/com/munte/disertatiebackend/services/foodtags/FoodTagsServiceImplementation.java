package com.munte.disertatiebackend.services.foodtags;

import com.munte.disertatiebackend.classes.models.manytomany.FoodTags;
import com.munte.disertatiebackend.classes.models.manytomany.compositekeys.foodtagskey.FoodTagsKeyBuilder;
import com.munte.disertatiebackend.repositories.FoodRepository;
import com.munte.disertatiebackend.repositories.FoodTagsRepository;
import com.munte.disertatiebackend.repositories.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodTagsServiceImplementation implements FoodTagsService{

    private final FoodTagsRepository foodTagsRepository;
    private final FoodRepository foodRepository;
    private final TagsRepository tagsRepository;

    @Autowired
    public FoodTagsServiceImplementation(FoodTagsRepository foodTagsRepository, FoodRepository foodRepository, TagsRepository tagsRepository) {
        this.foodTagsRepository = foodTagsRepository;
        this.foodRepository = foodRepository;
        this.tagsRepository = tagsRepository;
    }

    @Override
    public void saveNewRelation(Long foodId, Long tagId) {
        if(foodRepository.findById(foodId).isPresent() && tagsRepository.findById(tagId).isPresent()) {
            FoodTags foodTags = new FoodTags();
            foodTags.setId(new FoodTagsKeyBuilder().addFoodId(foodId).addTagsId(tagId).build());
            foodTagsRepository.save(foodTags);
        }
    }
}
