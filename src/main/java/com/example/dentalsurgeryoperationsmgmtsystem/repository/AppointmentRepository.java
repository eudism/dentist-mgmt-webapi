package com.example.dentalsurgeryoperationsmgmtsystem.repository;

import com.example.dentalsurgeryoperationsmgmtsystem.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
