package com.munte.disertatiebackend.services.users;

import com.munte.disertatiebackend.classes.dtos.usersdto.UserRegisterDTO;
import com.munte.disertatiebackend.classes.models.Users;
import com.munte.disertatiebackend.mappers.user.UserRegisterMapper;
import com.munte.disertatiebackend.repositories.RolesRepository;
import com.munte.disertatiebackend.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{
    private final UsersRepository usersRepository;
    private final RolesRepository rolesRepository;
    private final UserRegisterMapper userRegisterMapper;

    @Autowired
    public UserServiceImplementation(UsersRepository usersRepository, RolesRepository rolesRepository, UserRegisterMapper userRegisterMapper) {
        this.usersRepository = usersRepository;
        this.rolesRepository = rolesRepository;
        this.userRegisterMapper = userRegisterMapper;
    }

    @Override
    public ResponseEntity<String> registerNewAccount(UserRegisterDTO userRegisterDTO) {

        if(userRegisterMapper.toModel(userRegisterDTO) == null) {
            return ResponseEntity.badRequest().body("Wrong Credentials");
        } else {
            usersRepository.save(userRegisterMapper.toModel(userRegisterDTO));
            return ResponseEntity.ok("User " + userRegisterDTO.getMail() + " was created");
        }
    }
}
