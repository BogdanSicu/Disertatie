package com.munte.disertatiebackend.mappers;

import com.munte.disertatiebackend.classes.dtos.addressdto.AddressDTO;
import com.munte.disertatiebackend.classes.dtos.addressdto.AddressDTOBuilder;
import com.munte.disertatiebackend.classes.models.addresses.Addresses;
import com.munte.disertatiebackend.classes.models.addresses.AddressesBuilder;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper implements Mapper<AddressDTO, Addresses>{
    public AddressDTO toDTO(Addresses addresses) {
        AddressDTOBuilder addressDTOBuilder = new AddressDTOBuilder();
        return addressDTOBuilder
                .addCountry(addresses.getCountry())
                .addCounty(addresses.getCounty())
                .addCity(addresses.getCity())
                .addStreet(addresses.getStreet())
                .addStreetNumber(addresses.getStreetNumber())
                .addBuilding(addresses.getBuilding())
                .addStaircase(addresses.getStaircase())
                .addRoom(addresses.getRoom()).build();
    }

    public Addresses toModel(AddressDTO addressDTO) {
        AddressesBuilder addressesBuilder = new AddressesBuilder();
        return addressesBuilder
                .addCountry(addressDTO.getCountry())
                .addCounty(addressDTO.getCounty())
                .addCity(addressDTO.getCity())
                .addStreet(addressDTO.getStreet())
                .addStreetNumber(addressDTO.getStreetNumber())
                .addBuilding(addressDTO.getBuilding())
                .addStaircase(addressDTO.getStaircase())
                .addRoom(addressDTO.getRoom()).build();
    }
}
