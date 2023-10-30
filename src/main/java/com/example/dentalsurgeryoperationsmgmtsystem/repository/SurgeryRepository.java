package com.example.dentalsurgeryoperationsmgmtsystem.repository;

import com.example.dentalsurgeryoperationsmgmtsystem.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
}
