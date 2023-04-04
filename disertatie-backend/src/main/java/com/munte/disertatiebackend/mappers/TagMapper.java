package com.munte.disertatiebackend.mappers;

import com.munte.disertatiebackend.classes.dtos.TagsDTO;
import com.munte.disertatiebackend.classes.models.Tags;

public class TagMapper implements Mapper<TagsDTO, Tags> {
    @Override
    public TagsDTO toDTO(Tags model) {
        TagsDTO dto = new TagsDTO();
        dto.setName(model.getName());
        return dto;
    }

    @Override
    public Tags toModel(TagsDTO dto) {
        Tags model = new Tags();
        model.setName(dto.getName());
        return model;
    }
}
