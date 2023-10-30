package com.example.dentalsurgeryoperationsmgmtsystem.serviceImpl;

import com.example.dentalsurgeryoperationsmgmtsystem.model.Dentist;
import com.example.dentalsurgeryoperationsmgmtsystem.repository.DentistRepository;
import com.example.dentalsurgeryoperationsmgmtsystem.service.DentistService;
import org.springframework.stereotype.Service;

@Service
public class DentistImpl implements DentistService {
     private DentistRepository dentistRepository;

    public DentistImpl(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public Dentist addNewDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }
}
