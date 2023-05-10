package com.munte.disertatiebackend.controllers;

import com.munte.disertatiebackend.classes.dtos.usersdto.UserRegisterDTO;
import com.munte.disertatiebackend.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register-new-user")
    public ResponseEntity<String> registerNewAccount(@RequestBody UserRegisterDTO userRegisterDTO) {
        return userService.registerNewAccount(userRegisterDTO);
    }
}
