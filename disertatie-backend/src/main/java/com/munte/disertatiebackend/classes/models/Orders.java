package com.munte.disertatiebackend.classes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Orders {
    @Id
    @Column(name = "id")
    private Long id;

}
