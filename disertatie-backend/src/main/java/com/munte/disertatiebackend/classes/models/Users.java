package com.munte.disertatiebackend.classes.models;

import javax.persistence.*;

// he can have multiple orders
// he can have just 1 role
// he can have just 1 address
@Entity
@Table(name = "USERS")
public class Users {
    @Id
    @Column(name = "id")
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
}
