package com.example.simpleservicebootheroku.service;

import com.example.simpleservicebootheroku.model.User;
import com.example.simpleservicebootheroku.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getUserById(int id){
        return userRepository.findOne(id);
    }
}
