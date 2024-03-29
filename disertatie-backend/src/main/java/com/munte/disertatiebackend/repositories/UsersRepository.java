package com.munte.disertatiebackend.repositories;

import com.munte.disertatiebackend.classes.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findUserById(long l);

    Users findUserByMail(String mail);
}
