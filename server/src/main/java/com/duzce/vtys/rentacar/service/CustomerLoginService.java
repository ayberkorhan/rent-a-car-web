package com.duzce.vtys.rentacar.service;


import com.duzce.vtys.rentacar.dto.CustomerLoginDto;
import com.duzce.vtys.rentacar.dto.CustomerLoginDtoConverter;
import com.duzce.vtys.rentacar.model.CustomerLogin;
import com.duzce.vtys.rentacar.repository.CustomerLoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerLoginService {

    // @Autowired anatasyonu kullanılabilir. Spring Constructor Injection Tavsiye Ediyor.
    private final CustomerLoginRepository customerLoginRepository;

    private final CustomerService customerService;

    private final CustomerAdressService customerAdressService;

    public CustomerLoginService(CustomerLoginRepository customerLoginRepository, CustomerService customerService, CustomerAdressService customerAdressService) {
        this.customerLoginRepository = customerLoginRepository;
        this.customerService = customerService;
        this.customerAdressService = customerAdressService;
    }

    // Get All Customer Login
    public List<CustomerLoginDto> getAllCustomerLogin(){
        return new CustomerLoginDtoConverter().convert(customerLoginRepository.findAll());
    }


    // CustomerLoginDto
    public CustomerLoginDto save(CustomerLogin customerLogin) {
        return new CustomerLoginDtoConverter().convert(customerLoginRepository.save(customerLogin));
    }
}
