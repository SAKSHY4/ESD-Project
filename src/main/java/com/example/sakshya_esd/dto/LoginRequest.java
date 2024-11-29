package com.example.sakshya_esd.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "User Name is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
}

