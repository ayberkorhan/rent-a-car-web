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

    public CustomerLoginService(CustomerLoginRepository customerLoginRepository) {
        this.customerLoginRepository = customerLoginRepository;
    }

    public List<CustomerLoginDto> getAllCustomerLogin(){
        return new CustomerLoginDtoConverter().convert(customerLoginRepository.findAll());
    }


}
