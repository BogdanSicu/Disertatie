package com.munte.disertatiebackend.classes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// an ingredient can be assigned to multiple foods and the foods can have multiple ingredients
@Entity
@Table(name = "INGREDIENTS")
public class Ingredients {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
