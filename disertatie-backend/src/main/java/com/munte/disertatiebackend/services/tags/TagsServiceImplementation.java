package com.munte.disertatiebackend.services.tags;

import com.munte.disertatiebackend.classes.dtos.TagsDTO;
import com.munte.disertatiebackend.classes.models.Tags;
import com.munte.disertatiebackend.mappers.Mapper;
import com.munte.disertatiebackend.repositories.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TagsServiceImplementation implements TagsService{

    private final TagsRepository tagsRepository;
    private final Mapper<TagsDTO, Tags> tagsMapper;

    @Autowired
    public TagsServiceImplementation(TagsRepository tagsRepository, Mapper<TagsDTO, Tags> tagsMapper) {
        this.tagsRepository = tagsRepository;
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
}
