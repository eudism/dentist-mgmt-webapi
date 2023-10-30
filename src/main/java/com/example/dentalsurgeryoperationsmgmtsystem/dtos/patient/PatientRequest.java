package com.example.dentalsurgeryoperationsmgmtsystem.dtos.patient;

import com.example.dentalsurgeryoperationsmgmtsystem.dtos.address.AddressRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequest{
         private String name;
         private String phoneNumber;
         private AddressRequest addressRequest;

}
