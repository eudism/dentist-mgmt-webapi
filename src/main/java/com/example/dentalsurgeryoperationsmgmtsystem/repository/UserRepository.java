package com.example.dentalsurgeryoperationsmgmtsystem.repository;

import com.example.dentalsurgeryoperationsmgmtsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserByUserName(String name);
}
