package com.munte.disertatiebackend.services.address;

import com.munte.disertatiebackend.classes.dtos.addressdto.AddressDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AddressService {
    public List<AddressDTO> getAllAddresses();
    public AddressDTO getAddressById(Long id);
    public ResponseEntity<String> saveNewAddress(AddressDTO addressDTO);
}
