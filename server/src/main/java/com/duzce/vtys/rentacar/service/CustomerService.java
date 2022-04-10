package com.duzce.vtys.rentacar.service;


import com.duzce.vtys.rentacar.dto.CustomerDto;
import com.duzce.vtys.rentacar.dto.CustomerDtoConverter;
import com.duzce.vtys.rentacar.exception.CustomerLoginNotFoundException;
import com.duzce.vtys.rentacar.exception.CustomerNotFoundException;
import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.model.CustomerLogin;
import com.duzce.vtys.rentacar.repository.CustomerLoginRepository;
import com.duzce.vtys.rentacar.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    private final CustomerRepository customerRepository;

    private final CustomerLoginRepository customerLoginRepository;


    public CustomerService(CustomerRepository customerRepository, CustomerLoginRepository customerLoginRepository) {
        this.customerRepository = customerRepository;
        this.customerLoginRepository = customerLoginRepository;
    }

    public List<CustomerDto> getAllCustomer() {
        return new CustomerDtoConverter().convert(customerRepository.findAll());
    }
    public CustomerDto getCustomerById(Long id) throws CustomerNotFoundException {
        return new CustomerDtoConverter()
                .convert(customerRepository.findById(id)
                .orElseThrow(()-> new CustomerNotFoundException(id.toString() +"Numaralı Kullanıcı Bulunamadı")));
    }

    public CustomerDto save (Customer customer){
        CustomerLogin customerLogin =customerLoginRepository
                .findById(customer.getCustomerLogin().getLoginId()).orElseThrow(CustomerLoginNotFoundException::new);
        customer.setCustomerLogin(customerLogin);
        customerRepository.save(customer);
        return new CustomerDtoConverter().convert(customer);
    }

    public CustomerDto deleteCustomerById(Long id) throws CustomerNotFoundException {
        CustomerDto customer = getCustomerById(id);
        customerRepository.deleteById(id);
        return customer;
    }

}
