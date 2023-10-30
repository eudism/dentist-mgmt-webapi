package com.example.dentalsurgeryoperationsmgmtsystem.dtos.patient;

import com.example.dentalsurgeryoperationsmgmtsystem.dtos.address.AddressResponse;
import com.example.dentalsurgeryoperationsmgmtsystem.dtos.appointment.AppointmentResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class PatientResponse{
       private Long patientId;
       private String name;
       private String phoneNumber;
       private AddressResponse primaryAddress;
       private List<AppointmentResponseDTO> appointmentResponseDTO;
}
