package com.munte.disertatiebackend.repositories;

import com.munte.disertatiebackend.classes.models.addresses.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressesRepository extends JpaRepository<Addresses, Long> {
}
