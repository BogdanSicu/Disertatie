package com.munte.disertatiebackend.services.tags;

import com.munte.disertatiebackend.classes.dtos.TagsCounted;
import com.munte.disertatiebackend.classes.dtos.TagsDTO;
import com.munte.disertatiebackend.classes.models.Tags;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TagsService {
    public Tags getTagsByName(String name);
    public ResponseEntity<String> saveNewTag(TagsDTO tagsDTO);
    public List<TagsCounted> getTagsWithCounting ();
}
