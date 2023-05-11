package com.munte.disertatiebackend.services.users;

import com.munte.disertatiebackend.classes.dtos.usersdto.UserLoginDTO;
import com.munte.disertatiebackend.classes.dtos.usersdto.UserRegisterDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<String> registerNewAccount(UserRegisterDTO userRegisterDTO);
    public ResponseEntity<String> loginWithAccount(UserLoginDTO userLoginDTO);
}