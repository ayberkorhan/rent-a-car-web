package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.model.CustomerLogin;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerLoginDtoConverter {


    // Tekil DTO CONVERTER
    public CustomerLoginDto convert(CustomerLogin customerLogin){
        return new CustomerLoginDto(customerLogin.getLoginId(), customerLogin.getEmail(), customerLogin.getPassword(), customerLogin.getCreatedDate());
    }

    // List DTO CONVERTER
    public List<CustomerLoginDto> convert(List<CustomerLogin> customerLogin){
        return customerLogin.stream().map(customer -> new CustomerLoginDto(customer.getLoginId(), customer.getEmail(),customer.getPassword(),customer.getCreatedDate())).collect(Collectors.toList());
    }
}

