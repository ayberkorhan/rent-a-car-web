package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.model.CustomerLogin;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class CustomerLoginDtoConverter {


    // Customer DTO CONVERTER
    public CustomerLoginDto convert(CustomerLogin customerLogin) {
        return new CustomerLoginDto(
                customerLogin.getLoginId(),
                customerLogin.getEmail(),
                customerLogin.getPassword());
    }

    // Customer List DTO CONVERTER
    public List<CustomerLoginDto> convert(List<CustomerLogin> customerLogin) {
        return customerLogin.stream()
                .map(customer -> new CustomerLoginDto(
                        customer.getLoginId(),
                        customer.getEmail(),
                        customer.getPassword()
                        ))
                .collect(Collectors.toList());
    }
}

