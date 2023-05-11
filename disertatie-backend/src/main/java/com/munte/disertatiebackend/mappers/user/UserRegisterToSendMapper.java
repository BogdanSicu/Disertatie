package com.munte.disertatiebackend.mappers.user;

import com.munte.disertatiebackend.classes.dtos.usersdto.UserRegisterDTO;
import com.munte.disertatiebackend.classes.dtos.usersdto.UserSendDTO;
import com.munte.disertatiebackend.mappers.Mapper;
import com.munte.disertatiebackend.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterToSendMapper implements Mapper<UserSendDTO, UserRegisterDTO> {

    private final RolesRepository rolesRepository;

    @Autowired
    public UserRegisterToSendMapper(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public UserSendDTO toDTO(UserRegisterDTO model) {
        UserSendDTO userSend = new UserSendDTO();
        userSend.setName(model.getName());
        userSend.setRole(this.rolesRepository.findByName("Default").getName());
        userSend.setMail(model.getMail());
        return userSend;
    }

    @Override
    public UserRegisterDTO toModel(UserSendDTO dto) {
        return null;
    }
}
