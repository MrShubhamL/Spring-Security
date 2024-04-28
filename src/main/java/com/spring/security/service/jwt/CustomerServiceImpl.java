package com.spring.security.service.jwt;

import com.spring.security.model.Customer;
import com.spring.security.repositories.CustomerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements UserDetailsService {
    private final CustomerRepository userRepository;
    public CustomerServiceImpl(CustomerRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Write login to fetch customer data from db.
        Optional<Customer> customer = userRepository.getCustomersByUsername(username);
        if(customer.isEmpty()){
            System.out.println("User Not Found!!");
            throw new UsernameNotFoundException("No User Found!!");
        }
        return new User(customer.get().getUsername(), customer.get().getPassword(), customer.get().getAuthorities());
    }


}
