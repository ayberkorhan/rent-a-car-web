package com.duzce.vtys.rentacar.service;


import com.duzce.vtys.rentacar.dto.CustomerLoginDto;
import com.duzce.vtys.rentacar.dto.CustomerLoginDtoConverter;
import com.duzce.vtys.rentacar.repository.CustomerLoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerLoginService {

    // @Autowired anatasyonu kullanılabilir. Spring Constructor Injection Tavsiye Ediyor.
    private final CustomerLoginRepository customerLoginRepository;

    private final CustomerService customerService;

    public CustomerLoginService(CustomerLoginRepository customerLoginRepository, CustomerService customerService) {
        this.customerLoginRepository = customerLoginRepository;
        this.customerService = customerService;
    }

    public List<CustomerLoginDto> getAllCustomerLogin(){
        return new CustomerLoginDtoConverter().convert(customerLoginRepository.findAll());
    }


}
