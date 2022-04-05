package com.duzce.vtys.rentacar.service;


import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerLogin {

    private final CustomerRepository customerRepository;

    public CustomerLogin(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomer() {
        customerRepository.findAll().stream().forEach(u-> System.out.println(u.getIdentityNumber()));
        return customerRepository.findAll();
    }

}
