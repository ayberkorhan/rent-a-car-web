package com.duzce.vtys.rentacar.service;


import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }


}
