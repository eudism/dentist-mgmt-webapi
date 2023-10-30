package com.example.dentalsurgeryoperationsmgmtsystem.service;

import com.example.dentalsurgeryoperationsmgmtsystem.dtos.patient.PatientRequest;
import com.example.dentalsurgeryoperationsmgmtsystem.dtos.patient.PatientResponse;
import com.example.dentalsurgeryoperationsmgmtsystem.exceptions.PatientNotFoundException;
import com.example.dentalsurgeryoperationsmgmtsystem.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    public PatientRequest savePatient(PatientRequest patient);
    public List<PatientResponse> allPatients();
    public List<PatientResponse> getAllPatientsSortedByLastName();
    public PatientResponse getPatientById(Long patientId) throws PatientNotFoundException;
    public PatientResponse updatePatient(Long patientId, PatientRequest patientUpdateDTO) throws PatientNotFoundException;
    public boolean deletePatient(Long patientId);
    public List<PatientResponse> searchPatients(String searchString);



}
