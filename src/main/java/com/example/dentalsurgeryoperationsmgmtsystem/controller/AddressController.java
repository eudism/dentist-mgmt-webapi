package com.example.dentalsurgeryoperationsmgmtsystem.controller;

import com.example.dentalsurgeryoperationsmgmtsystem.model.Address;
import com.example.dentalsurgeryoperationsmgmtsystem.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/patient")
public class AddressController {
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    private AddressService addressService;

    @GetMapping("/addresses")
    public List<Address> listAddresses(){
        return addressService.getAllAddresses();
    }
}
