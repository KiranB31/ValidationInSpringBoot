package com.example.validation.service;

import com.example.validation.entity.LoginRequest;
import com.example.validation.entity.User;
import com.example.validation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;



    @Override
    public String validateLogin(LoginRequest loginRequest) {

        User existing = userRepository.findByUserName(loginRequest.getUserName());
        if (existing.getEmail().equalsIgnoreCase(loginRequest.getEmail())) {
            return "user verified sucessful";
        } else {
            return "Wrong Credentials";
        }

    }

    @Override
    public User getUserByUsername(String userName) {

            return userRepository.findByUserName(userName);

    }

    @Override
    public User getByUserId(User user, Long id) {

        User ex = this.userRepository.findById(user.getId()).get();

        if(ex.getId().equals(user.getId())) {
            return ex;
        }else {
            return null;
        }
    }
}
