package com.munte.disertatiebackend.services.tags;

import com.munte.disertatiebackend.classes.dtos.TagsCounted;
import com.munte.disertatiebackend.classes.dtos.TagsDTO;
import com.munte.disertatiebackend.classes.models.Tags;
import com.munte.disertatiebackend.classes.models.manytomany.FoodTags;
import com.munte.disertatiebackend.mappers.Mapper;
import com.munte.disertatiebackend.repositories.TagsRepository;
import com.munte.disertatiebackend.services.foodtags.FoodTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagsServiceImplementation implements TagsService{

    private final TagsRepository tagsRepository;
    private final FoodTagsService foodTagsService;
    private final Mapper<TagsDTO, Tags> tagsMapper;

    @Autowired
    public TagsServiceImplementation(TagsRepository tagsRepository, FoodTagsService foodTagsService, Mapper<TagsDTO, Tags> tagsMapper) {
        this.tagsRepository = tagsRepository;
        this.foodTagsService = foodTagsService;
        this.tagsMapper = tagsMapper;
    }

    @Override
    public Tags getTagsByName(String name) {
        return tagsRepository.findByName(name);
    }

    @Override
    public ResponseEntity<String> saveNewTag(TagsDTO tagsDTO) {

        if(tagsDTO == null) {
            return ResponseEntity.noContent().build();
        }

        if(tagsRepository.findByName(tagsDTO.getName()) == null) {
            tagsRepository.save(tagsMapper.toModel(tagsDTO));
            return ResponseEntity.ok("The tag was created");
        }

        return ResponseEntity.badRequest().body("This tag already exists");
    }

    @Override
    public List<TagsCounted> getTagsWithCounting() {

        List<TagsCounted> responseList = tagsRepository.findAll().stream().map(x -> new TagsCounted(x.getName())).toList();

        List<FoodTags> foodTagsList = foodTagsService.getAllRelations();

        for (TagsCounted tagsCounted : responseList) {
            for (FoodTags element : foodTagsList) {
                if(tagsCounted.getName().equals(element.getTag().getName())) {
                    tagsCounted.IncreaseCount();
                }
            }
        }

        return responseList;
    }
}
