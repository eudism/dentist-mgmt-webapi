package com.example.dentalsurgeryoperationsmgmtsystem.serviceImpl;

import com.example.dentalsurgeryoperationsmgmtsystem.model.Address;
import com.example.dentalsurgeryoperationsmgmtsystem.repository.AddressRepository;
import com.example.dentalsurgeryoperationsmgmtsystem.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressImpl implements AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll(Sort.by("city").ascending());
    }

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

}
