package com.munte.disertatiebackend.repositories;

import com.munte.disertatiebackend.classes.models.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<UserRoles, Long> {
    UserRoles findByName(String roleName);
}
