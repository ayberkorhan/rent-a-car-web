package com.duzce.vtys.rentacar.service;


import com.duzce.vtys.rentacar.dto.CustomerDto;
import com.duzce.vtys.rentacar.dto.CustomerDtoConverter;
import com.duzce.vtys.rentacar.dto.CustomerLoginDto;
import com.duzce.vtys.rentacar.exception.CustomerNotFoundException;
import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.model.CustomerLogin;
import com.duzce.vtys.rentacar.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    private final CustomerRepository customerRepository;
    private final CustomerLoginService customerLoginService;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerLoginService customerLoginService, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerLoginService = customerLoginService;
        this.customerDtoConverter = customerDtoConverter;
    }

    public List<CustomerDto> getAllCustomer() {
        return customerDtoConverter.convert(customerRepository.findAll());
    }

    protected Customer findCustomerById(Long id) throws CustomerNotFoundException {
        return customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer could not find by id: " + id.toString())
        );
    }

    public CustomerDto getCustomerById(Long id) throws CustomerNotFoundException {
        return customerDtoConverter
                .convert(customerRepository.findById(id)
                        .orElseThrow(() -> new CustomerNotFoundException(id.toString() + "Numaralı Kullanıcı Bulunamadı")));
    }

    public CustomerDto save(Customer customer) {
        CustomerLogin customerLogin = customerLoginService.
                findCustomerLoginById(customer.getCustomerLogin().getLoginId());

        customer.setCustomerLogin(customerLogin);
        customerRepository.save(customer);
        return customerDtoConverter.convert(customer);
    }


    public Customer saveAll(Customer customer){
        return customerRepository.save(customer);

    }

    public CustomerDto deleteCustomerById(Long id) throws CustomerNotFoundException {
        CustomerDto customer = getCustomerById(id);
        customerRepository.deleteById(id);
        return customer;
    }

}
