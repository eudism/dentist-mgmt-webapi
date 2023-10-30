package com.example.dentalsurgeryoperationsmgmtsystem.dtos.address;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressResponse{
        private Integer addressId;
        private String street;
        private String city;
        private String state;
        private int zipcode;
}
