package com.munte.disertatiebackend.services.users;

import com.munte.disertatiebackend.classes.dtos.usersdto.UserLoginDTO;
import com.munte.disertatiebackend.classes.dtos.usersdto.UserRegisterDTO;
import com.munte.disertatiebackend.mappers.user.UserLoginToSendMapper;
import com.munte.disertatiebackend.mappers.user.UserRegisterMapper;
import com.munte.disertatiebackend.mappers.user.UserRegisterToSendMapper;
import com.munte.disertatiebackend.repositories.UsersRepository;
import com.munte.disertatiebackend.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{
    private final UsersRepository usersRepository;
    private final UserRegisterMapper userRegisterMapper;
    private final JWTUtility jwtUtility;
    private final UserRegisterToSendMapper userRegisterToSendMapper;
    private final UserLoginToSendMapper userLoginToSendMapper;

    @Autowired
    public UserServiceImplementation(UsersRepository usersRepository, UserRegisterMapper userRegisterMapper, JWTUtility jwtUtility, UserRegisterToSendMapper userRegisterToSendMapper, UserLoginToSendMapper userLoginToSendMapper) {
        this.usersRepository = usersRepository;
        this.userRegisterMapper = userRegisterMapper;
        this.jwtUtility = jwtUtility;
        this.userRegisterToSendMapper = userRegisterToSendMapper;
        this.userLoginToSendMapper = userLoginToSendMapper;
    }

    @Override
    public ResponseEntity<String> registerNewAccount(UserRegisterDTO userRegisterDTO) {

        if(userRegisterMapper.toModel(userRegisterDTO) == null) {
            return ResponseEntity.badRequest().body("Wrong Credentials");
        }
        usersRepository.save(userRegisterMapper.toModel(userRegisterDTO));
//          return ResponseEntity.ok("User " + userRegisterDTO.getMail() + " was created");
        return ResponseEntity.ok(jwtUtility.generateToken(userRegisterToSendMapper.toDTO(userRegisterDTO)));


    }

    @Override
    public ResponseEntity<String> loginWithAccount(UserLoginDTO userLoginDTO) {
        if(userLoginToSendMapper.toDTO(userLoginDTO) == null) {
            return ResponseEntity.badRequest().body("Wrong Credentials");
        }
        return ResponseEntity.ok(jwtUtility.generateToken(userLoginToSendMapper.toDTO(userLoginDTO)));
    }
}