package com.munte.disertatiebackend.classes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.munte.disertatiebackend.classes.models.addresses.Addresses;
import com.munte.disertatiebackend.classes.models.manytomany.FoodIngredients;
import com.munte.disertatiebackend.classes.models.manytomany.FoodsInOrders;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public class Orders {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Addresses address;

    @OneToMany(mappedBy = "order")
    private Set<FoodsInOrders> ordersWithFood = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Addresses getAddress() {
        return address;
    }

    public void setAddress(Addresses address) {
        this.address = address;
    }

    public Set<FoodsInOrders> getOrdersWithFood() {
        return ordersWithFood;
    }
}
