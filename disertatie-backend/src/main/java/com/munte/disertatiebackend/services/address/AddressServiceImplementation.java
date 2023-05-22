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
import java.util.Objects;

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
    public ResponseEntity<String> saveNewAddress(AddressDTO addressDTO) {
        if(addressDTO == null) {
            return ResponseEntity.noContent().build();
        }

        if(addressesRepository.findAll().stream()
                .filter(x -> x.getCountry().equals(addressDTO.getCountry()) &&
//                        x.getCounty().equals(addressDTO.getCounty()) &&
                        x.getCity().equals(addressDTO.getCity()) &&
                        x.getStreet().equals(addressDTO.getStreet()) &&
                        x.getStreetNumber().equals(addressDTO.getStreetNumber()) &&
                        x.getBuilding().equals(addressDTO.getBuilding()) &&
//                        x.getStaircase().equals(addressDTO.getStaircase()) &&
                        x.getRoom().equals(addressDTO.getRoom())).toList().size() == 0) {
            addressesRepository.save(addressMapper.toModel(addressDTO));
            return ResponseEntity.ok("The address was created");
        }
        return ResponseEntity.badRequest().body("This address already exists");
    }
}
