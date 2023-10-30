package com.example.dentalsurgeryoperationsmgmtsystem.controller;

import com.example.dentalsurgeryoperationsmgmtsystem.dtos.patient.PatientRequest;
import com.example.dentalsurgeryoperationsmgmtsystem.dtos.patient.PatientResponse;
import com.example.dentalsurgeryoperationsmgmtsystem.exceptions.PatientNotFoundException;
import com.example.dentalsurgeryoperationsmgmtsystem.model.Patient;
import com.example.dentalsurgeryoperationsmgmtsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/patient")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public ResponseEntity<List <PatientResponse>> findAllPatients(){
        return ResponseEntity.ok(patientService.allPatients());
    }

    @GetMapping("/list")
    public ResponseEntity<List<?>> listAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatientsSortedByLastName());
    }

    @GetMapping("/get/{patientId}")
    public ResponseEntity<PatientResponse> getPatient(@PathVariable Long patientId) throws PatientNotFoundException {
        return ResponseEntity.ok(patientService.getPatientById(patientId));

    }

    @PostMapping("/register")
    public ResponseEntity<String> registerPatient(@RequestBody PatientRequest patient) {
        patientService.savePatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body("Patient successfully added.");
    }

    @PutMapping("/update/{patientId}")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable Long patientId, @RequestBody PatientRequest updatedPatient) throws PatientNotFoundException {
        PatientResponse patientResponse = patientService.updatePatient(patientId, updatedPatient);
        if (patientResponse != null) {
            return ResponseEntity.ok(patientResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable Long patientId) {
        boolean isDeleted = patientService.deletePatient(patientId);
        if (isDeleted) {
            return ResponseEntity.ok("Patient successfully deleted.");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search/{searchString}")
    public ResponseEntity<List<PatientResponse>> searchPatients(@PathVariable String searchString) {
        List<PatientResponse> patients = patientService.searchPatients(searchString);
        if (patients.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patients);
    }






}
