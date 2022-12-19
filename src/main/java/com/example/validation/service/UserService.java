package com.example.validation.service;

import com.example.validation.entity.LoginRequest;
import com.example.validation.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String validateLogin(LoginRequest loginRequest);


    User getUserByUsername(String userName);
}
