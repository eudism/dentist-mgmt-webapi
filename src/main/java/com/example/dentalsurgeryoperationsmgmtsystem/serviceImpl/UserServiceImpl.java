package com.example.dentalsurgeryoperationsmgmtsystem.serviceImpl;

import com.example.dentalsurgeryoperationsmgmtsystem.model.User;
import com.example.dentalsurgeryoperationsmgmtsystem.repository.UserRepository;
import com.example.dentalsurgeryoperationsmgmtsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByName(String username) {
        return userRepository.findUserByUserName(username);
    }
}
