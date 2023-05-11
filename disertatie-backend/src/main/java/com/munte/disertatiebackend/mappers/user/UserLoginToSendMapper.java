package com.munte.disertatiebackend.mappers.user;

import com.munte.disertatiebackend.classes.dtos.usersdto.UserLoginDTO;
import com.munte.disertatiebackend.classes.dtos.usersdto.UserSendDTO;
import com.munte.disertatiebackend.mappers.Mapper;
import com.munte.disertatiebackend.repositories.RolesRepository;
import com.munte.disertatiebackend.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserLoginToSendMapper implements Mapper<UserSendDTO, UserLoginDTO> {

    private final RolesRepository rolesRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public UserLoginToSendMapper(RolesRepository rolesRepository, UsersRepository usersRepository) {
        this.rolesRepository = rolesRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public UserSendDTO toDTO(UserLoginDTO model) {
        try {
            UserSendDTO userSend = new UserSendDTO();
            userSend.setMail(model.getEmail());
            userSend.setName(usersRepository.findUserByMail(model.getEmail()).getName());
            userSend.setRole(usersRepository.findUserByMail(model.getEmail()).getRole().getName());
            return userSend;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserLoginDTO toModel(UserSendDTO dto) {

        return null;
    }
}
