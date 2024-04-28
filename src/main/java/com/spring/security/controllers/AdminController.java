package com.spring.security.controllers;


import com.spring.security.enums.UserRole;
import com.spring.security.model.Customer;
import com.spring.security.repositories.CustomerRepository;
import com.spring.security.service.UserService;
import com.spring.security.service.jwt.CustomerServiceImpl;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    @Autowired
    CustomerRepository customerRepository;

     @GetMapping("/adminDetails")
    public ResponseEntity<?> getEmployee(){
        return ResponseEntity.ok("This is admin dashboard");
    }
}
