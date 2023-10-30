package com.example.dentalsurgeryoperationsmgmtsystem.serviceImpl;

import com.example.dentalsurgeryoperationsmgmtsystem.model.Surgery;
import com.example.dentalsurgeryoperationsmgmtsystem.repository.SurgeryRepository;
import com.example.dentalsurgeryoperationsmgmtsystem.service.SurgeryService;
import org.springframework.stereotype.Service;

@Service
public class SurgeryImpl implements SurgeryService {
    private SurgeryRepository surgeryRepository;

    public SurgeryImpl(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    @Override
    public Surgery addNewSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }
}
