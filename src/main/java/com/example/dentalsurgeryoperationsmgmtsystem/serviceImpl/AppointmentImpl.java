package com.example.dentalsurgeryoperationsmgmtsystem.serviceImpl;

import com.example.dentalsurgeryoperationsmgmtsystem.model.Appointment;
import com.example.dentalsurgeryoperationsmgmtsystem.repository.AppointmentRepository;
import com.example.dentalsurgeryoperationsmgmtsystem.service.AppointmentService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;

    public AppointmentImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment addNewAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
