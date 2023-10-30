package com.example.dentalsurgeryoperationsmgmtsystem.serviceImpl;

import com.example.dentalsurgeryoperationsmgmtsystem.dtos.address.AddressRequest;
import com.example.dentalsurgeryoperationsmgmtsystem.dtos.address.AddressResponse;
import com.example.dentalsurgeryoperationsmgmtsystem.dtos.patient.PatientRequest;
import com.example.dentalsurgeryoperationsmgmtsystem.dtos.patient.PatientResponse;
import com.example.dentalsurgeryoperationsmgmtsystem.exceptions.PatientNotFoundException;
import com.example.dentalsurgeryoperationsmgmtsystem.model.Address;
import com.example.dentalsurgeryoperationsmgmtsystem.model.Patient;
import com.example.dentalsurgeryoperationsmgmtsystem.repository.AddressRepository;
import com.example.dentalsurgeryoperationsmgmtsystem.repository.PatientRepository;
import com.example.dentalsurgeryoperationsmgmtsystem.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientImpl implements PatientService {

    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;
    private final AddressRepository addressRepository;


    public PatientImpl(PatientRepository patientRepository,
                       AddressRepository addressRepository) {
        this.patientRepository = patientRepository;
        this.addressRepository = addressRepository;
    }


    @Override
    public PatientRequest savePatient(PatientRequest patientRequest) {
        Patient patient= modelMapper.map(patientRequest, Patient.class);
        Address address= modelMapper.map(patientRequest.getAddressRequest(), Address.class);
        Address savedAddress= addressRepository.save(address);
        patient.setAddress(savedAddress);
        var savedPatient= patientRepository.save(patient);
        return modelMapper.map(savedPatient,PatientRequest.class);
    }

//    @Override
//    public List<PatientResponse> allPatients() {
//        return patientRepository.findAll().
//                stream().map(p -> new PatientResponse(
//                        p.getPatientId(),
//                        p.getName(),
//                                new AddressResponse(
//                                        p.getAddress().getAddressId(),
//                                        p.getAddress().getStreet(),
//                                        p.getAddress().getCity(),
//                                        p.getAddress().getState(),
//                                        p.getAddress().getZipCode()
//                                )
//                )
//
//                ).toList();
//    }
    public List<PatientResponse> allPatients() {
    List<Patient> patients = patientRepository.findAll();
    return patients.stream()
            .map(patient -> {
                PatientResponse patientDTO = modelMapper.map(patient, PatientResponse.class);
                AddressResponse addressDTO = modelMapper.map(patient.getAddress(), AddressResponse.class);
                patientDTO.setPrimaryAddress(addressDTO);
//                List<AppointmentResponseDTO> appointmentDTOs = patient.getAppointments().stream()
//                        .map(appointment -> modelMapper.map(appointment, AppointmentResponseDTO.class))
//                        .collect(Collectors.toList());
//                patientDTO.setAppointmentResponseDTO(appointmentDTOs);
                return patientDTO;

            })
            .collect(Collectors.toList());
}


    @Override
    public List<PatientResponse> getAllPatientsSortedByLastName() {
        List<Patient> patients= patientRepository.findAll(Sort.by(Sort.Order.asc("name")));
        return patients.stream()
                .map(patient -> {
                    PatientResponse patientDTO = modelMapper.map(patient, PatientResponse.class);
                    AddressResponse addressDTO = modelMapper.map(patient.getAddress(), AddressResponse.class);
                    patientDTO.setPrimaryAddress(addressDTO);

                    return patientDTO;

                })
                .collect(Collectors.toList());
    }

//    @Override
//    public PatientResponse getPatientById(Long patientId) throws PatientNotFoundException {
//        Patient patient= patientRepository.findById(patientId);
//        return patientRepository.findById(patientId)
//                .orElseThrow(()-> new PatientNotFoundException(String.format("Error: patient, %d, is not found", patientId)));
//    }

    @Override
    public PatientResponse getPatientById(Long patientId) throws PatientNotFoundException {
        Patient patient= patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException(String.format("Error: Patient with ID %d is not found", patientId)));

        PatientResponse patientResponse = modelMapper.map(patient, PatientResponse.class);

        AddressResponse addressDTO = modelMapper.map(patient.getAddress(), AddressResponse.class);
        patientResponse.setPrimaryAddress(addressDTO);

        return patientResponse;
    }


    @Override
    public PatientResponse updatePatient(Long patientId, PatientRequest patientUpdateDTO) throws PatientNotFoundException {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException(String.format("Error: Patient with ID %d is not found", patientId)));

        // Map the DTO fields onto the patient entity
        modelMapper.map(patientUpdateDTO, patient);

        // Save the updated patient entity to the database
        Patient updatedPatient = patientRepository.save(patient);

        // Convert the updated patient entity to a DTO to return to the client
        return modelMapper.map(updatedPatient, PatientResponse.class);
    }

    @Override
    public boolean deletePatient(Long patientId) {
        if(patientRepository.existsById(patientId)) {
            patientRepository.deleteById(patientId);
            return true;
        }
        return false;
    }

    @Override
    public List<PatientResponse> searchPatients(String searchString) {
      List<Patient> patients = patientRepository.findByNameContainingIgnoreCase(searchString);
        return patients.stream()
                .map(patient -> {
                    PatientResponse patientDTO = modelMapper.map(patient, PatientResponse.class);
                    AddressResponse addressDTO = modelMapper.map(patient.getAddress(), AddressResponse.class);
                    patientDTO.setPrimaryAddress(addressDTO);

                    return patientDTO;

                })
                .collect(Collectors.toList());


    }


}
