package com.duzce.vtys.rentacar.service;


import com.duzce.vtys.rentacar.dto.CustomerDto;
import com.duzce.vtys.rentacar.dto.CustomerDtoConverter;
import com.duzce.vtys.rentacar.model.Customer;
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
        return new CustomerDtoConverter().convert(customerRepository.findAll());
    }
    public CustomerDto getCustomerById(Long id){
        return new CustomerDtoConverter().convert(customerRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    public Customer save (Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

}
