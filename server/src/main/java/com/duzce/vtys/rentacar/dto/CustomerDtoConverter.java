package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    public List<CustomerDto> convert(List<Customer> customers) {

        return customers.stream()
                .map(c -> new CustomerDto(
                        c.getCustomerId(),
                        c.getFirstName(),
                        c.getLastName(),
                        c.getIdentityNumber(),
                        c.getCustomerLogin().getLoginId()))
                .collect(Collectors.toList());
    }

    public CustomerDto convert(Customer customer) {
        return new CustomerDto(customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getIdentityNumber(),
                customer.getCustomerLogin().getLoginId());
    }
}
