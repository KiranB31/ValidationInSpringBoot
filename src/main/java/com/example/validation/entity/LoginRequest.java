package com.example.validation.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class LoginRequest {

    private String userName;
    private String email;
}
