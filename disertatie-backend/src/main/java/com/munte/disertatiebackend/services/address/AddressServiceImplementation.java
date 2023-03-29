package com.munte.disertatiebackend.services.address;

import com.munte.disertatiebackend.classes.dtos.addressdto.AddressDTO;
import com.munte.disertatiebackend.classes.models.addresses.Addresses;
import com.munte.disertatiebackend.mappers.AddressMapper;
import com.munte.disertatiebackend.repositories.AddressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImplementation implements AddressService{

    private final AddressesRepository addressesRepository;
    private final AddressMapper addressMapper;

    @Autowired
    public AddressServiceImplementation(AddressesRepository addressesRepository, AddressMapper addressMapper) {
        this.addressesRepository = addressesRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public List<AddressDTO> getAllAddresses() {
        List<AddressDTO> listDTO = new ArrayList<>();
        for(Addresses address : addressesRepository.findAll().stream().toList()) {
            listDTO.add(addressMapper.toDTO(address));
        }
        return listDTO;
    }

    @Override
    public AddressDTO getAddressById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<AddressDTO> saveNewAddress(AddressDTO addressDTO) {
        return null;
    }
}
