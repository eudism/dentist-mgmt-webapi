package com.example.dentalsurgeryoperationsmgmtsystem.service;

import com.example.dentalsurgeryoperationsmgmtsystem.model.User;

public interface UserService {

    public User findByName(String username);
}
