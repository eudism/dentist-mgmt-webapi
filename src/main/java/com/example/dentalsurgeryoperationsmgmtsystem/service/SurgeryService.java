package com.example.dentalsurgeryoperationsmgmtsystem.service;

import com.example.dentalsurgeryoperationsmgmtsystem.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryService {
    public Surgery addNewSurgery(Surgery surgery);

}
