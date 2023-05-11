package com.munte.disertatiebackend.mappers;

import com.munte.disertatiebackend.classes.dtos.TagsDTO;
import com.munte.disertatiebackend.classes.models.Tags;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TagsMapper implements Mapper<TagsDTO, Tags>{
    @Override
    public TagsDTO toDTO(Tags model) {
        TagsDTO tagDTO = new TagsDTO();
        tagDTO.setName(model.getName());
        return tagDTO;
    }

    @Override
    public Tags toModel(TagsDTO dto) {
        Tags tag = new Tags();
        tag.setName(dto.getName());
        return tag;
    }
}
