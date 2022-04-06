package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.model.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerDtoConverter {

    public List<CustomerDto> convert(List<Customer> customers){
        return customers.stream().map(c -> new CustomerDto(c.getCustomerID(),c.getCustomerLoginId(),c.getFirstName(),c.getLastName(),c.getIdentityNumber(),c.getBirthday(),c.getCratedDate())).collect(Collectors.toList());
    }
}
