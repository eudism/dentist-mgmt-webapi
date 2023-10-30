package com.example.dentalsurgeryoperationsmgmtsystem.dtos.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest{
        private String street;
        private String city;
        private String state;
        private int zipCode;
}

