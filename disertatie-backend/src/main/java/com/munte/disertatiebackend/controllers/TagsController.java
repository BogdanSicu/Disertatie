package com.munte.disertatiebackend.controllers;

import com.munte.disertatiebackend.classes.dtos.TagsCounted;
import com.munte.disertatiebackend.services.tags.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tags/")
public class TagsController {

    private final TagsService tagsService;

    @Autowired
    public TagsController(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @GetMapping("get-counted-tags")
    public List<TagsCounted> getTagsWithCounting() {
        return tagsService.getTagsWithCounting();
    }
}
