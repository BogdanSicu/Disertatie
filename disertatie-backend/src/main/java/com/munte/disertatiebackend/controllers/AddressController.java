package com.munte.disertatiebackend.controllers;

import com.munte.disertatiebackend.classes.dtos.addressdto.AddressDTO;
import com.munte.disertatiebackend.services.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/addresses/")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("get-all-addresses")
    public ResponseEntity<List<AddressDTO>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @PostMapping("save-address")
    public ResponseEntity<String> saveAddress(@RequestBody AddressDTO addressDTO) {
        return addressService.saveNewAddress(addressDTO);
    }
}
