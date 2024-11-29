package com.example.sakshya_esd.mapper;

import com.example.sakshya_esd.dto.SignupRequest;
import com.example.sakshya_esd.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class SignupToStudentMapper {

    public Student toEntity(SignupRequest request){
        return Student.builder()
                .rollNumber(request.getUsername())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
    }
}

