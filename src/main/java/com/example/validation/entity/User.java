package com.example.validation.entity;

import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "users")
@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=2, message = "First Name should have atleast 2 characters")
    @Pattern(regexp = "^[A-Z]{1,10}$",message = " First name In Capital ")
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min=2, message = "Last Name should have atleast 2 characters")
    @Pattern(regexp = "^[A-Z]{1,10}$",message = " Last name In Capital ")
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Size(min=2, message = "User Name should have atleast 2 characters")
    @Pattern(regexp = "^[A-Za-z0-9]{1,5}$",message = "username must be of 1 to 5 length with no special characters")
    @Column(name = "user_name")
    private String userName;

    @NotBlank
    @Email
    @Column(name = "emails")
    private String email;

//    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$",
//            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
//    private String password;





}
