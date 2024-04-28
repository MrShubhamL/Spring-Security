package com.spring.security.service;

import com.spring.security.model.Customer;

import java.util.Optional;

public interface UserService {
    Customer createCustomer(Customer customer);
    boolean getCustomerByEmail(String email);
}
