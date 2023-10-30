package com.example.dentalsurgeryoperationsmgmtsystem.dtos.appointment;

import com.example.dentalsurgeryoperationsmgmtsystem.model.Dentist;
import com.example.dentalsurgeryoperationsmgmtsystem.model.Patient;
import com.example.dentalsurgeryoperationsmgmtsystem.model.Surgery;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class AppointmentResponseDTO {
    private Long appointmentId;
    private String status;
    private LocalDate localDate;
    private Patient patient;
    private Dentist dentist;
    private Surgery surgery;

}
