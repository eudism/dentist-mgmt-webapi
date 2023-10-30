package com.example.dentalsurgeryoperationsmgmtsystem.service;

import com.example.dentalsurgeryoperationsmgmtsystem.model.Appointment;
import org.springframework.stereotype.Repository;


public interface AppointmentService {
    public Appointment addNewAppointment(Appointment appointment);
}
