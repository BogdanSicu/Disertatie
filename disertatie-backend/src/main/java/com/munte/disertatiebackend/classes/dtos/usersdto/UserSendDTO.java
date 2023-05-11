package com.munte.disertatiebackend.classes.dtos.usersdto;

import com.munte.disertatiebackend.classes.dtos.addressdto.AddressDTO;

public class UserSendDTO {
    private String name;
    private String mail;
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
