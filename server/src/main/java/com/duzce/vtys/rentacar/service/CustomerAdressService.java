package com.duzce.vtys.rentacar.service;


import com.duzce.vtys.rentacar.dto.CustomerAdressDto;
import com.duzce.vtys.rentacar.dto.CustomerAdressDtoConverter;
import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.model.CustomerAdress;
import com.duzce.vtys.rentacar.repository.CustomerAdressRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAdressService {

    private final CustomerAdressRepository customerAdressRepository;


    public CustomerAdressService(CustomerAdressRepository customerAdressRepository, CustomerService customerService) {
        this.customerAdressRepository = customerAdressRepository;
    }

    public List<CustomerAdress> getCustomerAdressByCustomerId(Long id) {
        return customerAdressRepository.getCustomerAdressByCustomerId(id);
    }


}
