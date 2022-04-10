package com.duzce.vtys.rentacar.service;


import com.duzce.vtys.rentacar.dto.CustomerLoginDto;
import com.duzce.vtys.rentacar.dto.CustomerLoginDtoConverter;
import com.duzce.vtys.rentacar.exception.CustomerLoginNotFoundException;
import com.duzce.vtys.rentacar.model.CustomerLogin;
import com.duzce.vtys.rentacar.repository.CustomerLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerLoginService {

    // @Autowired anatasyonu kullanılabilir. Spring Constructor Injection Tavsiye Ediyor.
    private final CustomerLoginRepository customerLoginRepository;

    private final CustomerService customerService;
    private final CustomerLoginDtoConverter customerLoginDtoConverter;

    @Autowired //Circular Dependencies in Spring
    public CustomerLoginService(CustomerLoginRepository customerLoginRepository, @Lazy CustomerService customerService, CustomerLoginDtoConverter customerLoginDtoConverter) {
        this.customerLoginRepository = customerLoginRepository;
        this.customerService = customerService;
        this.customerLoginDtoConverter = customerLoginDtoConverter;
    }

    // Get All Customer Login
    public List<CustomerLoginDto> getAllCustomerLogin(){
        return new CustomerLoginDtoConverter()
                .convert(customerLoginRepository.findAll());
    }


    // CustomerLoginDto
    public CustomerLoginDto save(CustomerLogin customerLogin) {
        return new CustomerLoginDtoConverter()
                .convert(customerLoginRepository.save(customerLogin));
    }

    public CustomerLoginDto getCustomerLoginById(Long id){
        return customerLoginDtoConverter.convert(
                customerLoginRepository.findById(id)
                        .orElseThrow(() -> new CustomerLoginNotFoundException("Customer could not find by id :" +id.toString()))
        );
    }

    public CustomerLogin findCustomerLoginById(Long id){
        return customerLoginRepository.findById(id)
                .orElseThrow(
                        ()-> new CustomerLoginNotFoundException("Customer could not find by id :" +id.toString())
                );
    }

    public CustomerLogin deleteCustomerById(Long id) throws CustomerLoginNotFoundException  {
        CustomerLogin customerLogin = findCustomerLoginById(id);
        customerLoginRepository.deleteById(id);
        return customerLogin;

    }

}
