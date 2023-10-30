package com.example.dentalsurgeryoperationsmgmtsystem.service;

import com.example.dentalsurgeryoperationsmgmtsystem.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    public List<Address> getAllAddresses();
    public Address addAddress(Address address);


}
