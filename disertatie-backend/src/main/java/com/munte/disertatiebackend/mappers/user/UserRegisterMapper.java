package com.munte.disertatiebackend.mappers.user;

import com.munte.disertatiebackend.classes.dtos.usersdto.UserRegisterDTO;
import com.munte.disertatiebackend.classes.models.Users;
import com.munte.disertatiebackend.mappers.Mapper;
import com.munte.disertatiebackend.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserRegisterMapper implements Mapper<UserRegisterDTO, Users> {

    private final RolesRepository rolesRepository;
    private final String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    @Autowired
    public UserRegisterMapper(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public UserRegisterDTO toDTO(Users model) {
        return null;
    }

    @Override
    public Users toModel(UserRegisterDTO dto) {

        if(dto != null &&
                !dto.getName().isEmpty() &&
                !dto.getPassword().isEmpty() &&
                Pattern.compile(regex).matcher(dto.getMail()).matches()) {

            Users newUser = new Users();
            newUser.setRole(this.rolesRepository.findByName("Default"));
            newUser.setMail(dto.getMail());
            newUser.setPassword(dto.getPassword());
            newUser.setName(dto.getName());

            return newUser;
        }

        return null;
    }
}
