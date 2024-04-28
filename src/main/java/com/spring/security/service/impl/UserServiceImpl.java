package com.spring.security.service.impl;

import com.spring.security.model.Customer;
import com.spring.security.repositories.CustomerRepository;
import com.spring.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setRole("CUSTOMER");
        return customerRepository.save(customer);
    }

    @Override
    public boolean getCustomerByEmail(String username) {
        return customerRepository.getCustomersByUsername(username).isPresent();
    }
}
