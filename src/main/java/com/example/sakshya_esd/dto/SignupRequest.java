package com.example.sakshya_esd.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignupRequest {
    @NotBlank(message = "Roll Number is required")
    private String username;
    @NotBlank(message = "email is required")
    private String email;
    @NotBlank(message = "firstName is required")
    private String firstName;
    @NotBlank(message = "lastName is required")
    private String lastName;
    @NotBlank(message = "Password is required")
    private String password;
}

