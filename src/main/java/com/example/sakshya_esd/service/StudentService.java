package com.example.sakshya_esd.service;

import com.example.sakshya_esd.auth.JWTService;
import com.example.sakshya_esd.auth.StudentPrincipal;
import com.example.sakshya_esd.entity.Student;
import com.example.sakshya_esd.repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StudentRepository studentRepository;

    public UserDetails loadUserByUsername(String rollnumber) throws UsernameNotFoundException {
        Student student = studentRepository.findByRollNumber(rollnumber);
        if(student == null) {
            throw new UsernameNotFoundException(rollnumber);
        }
        return new StudentPrincipal(student);
    }

    public ResponseEntity<Student> getDetails(HttpServletRequest httpRequest) {
        String rollNumber = getRollNumber(httpRequest);
        if(rollNumber == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(studentRepository.findByRollNumber(rollNumber));
    }

    public String getRollNumber(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");

        String token = authHeader != null && authHeader.startsWith("Bearer ") ? authHeader.substring(7) : null;

        return (token != null) ? jwtService.extractUserName(token):null;
    }
}
