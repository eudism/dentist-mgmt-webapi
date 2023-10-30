package com.example.dentalsurgeryoperationsmgmtsystem.repository;

import com.example.dentalsurgeryoperationsmgmtsystem.model.Address;
import com.example.dentalsurgeryoperationsmgmtsystem.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {

}
