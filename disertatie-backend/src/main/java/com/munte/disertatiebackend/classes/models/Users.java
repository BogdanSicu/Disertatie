package com.munte.disertatiebackend.classes.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// he can have multiple orders
// he can have just 1 role
// he can have just 1 address
@Entity
@Table(name = "USERS")
public class Users {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "mail")
    private String mail;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_roles_id", referencedColumnName = "id")
    private UserRoles role;

    @OneToMany(mappedBy = "user")
    private Set<FavouriteFoods> favouriteFoods = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Addresses address;

    @OneToMany(mappedBy = "user")
    private Set<Orders> orders = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    public Set<FavouriteFoods> getFavouriteFoods() {
        return favouriteFoods;
    }

    public void setFavouriteFoods(Set<FavouriteFoods> favouriteFoods) {
        this.favouriteFoods = favouriteFoods;
    }

    public Addresses getAddress() {
        return address;
    }

    public void setAddress(Addresses address) {
        this.address = address;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
