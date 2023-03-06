package com.munte.disertatiebackend.repositories;

import com.munte.disertatiebackend.classes.models.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tags, Long> {
}
