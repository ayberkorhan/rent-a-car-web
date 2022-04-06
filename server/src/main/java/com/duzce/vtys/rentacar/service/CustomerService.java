package com.duzce.vtys.rentacar.service;


import com.duzce.vtys.rentacar.dto.CustomerDto;
import com.duzce.vtys.rentacar.dto.CustomerDtoConverter;
import com.duzce.vtys.rentacar.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDto> getAllCustomer() {
        customerRepository.findAll().stream().forEach(u -> System.out.println("Login ID:" + u.getCustomerLoginId()));
        return new CustomerDtoConverter().convert(customerRepository.findAll());
    }

}
