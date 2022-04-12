package com.duzce.vtys.rentacar.service;


import com.duzce.vtys.rentacar.dto.CustomerAdressDto;
import com.duzce.vtys.rentacar.dto.CustomerAdressDtoConverter;
import com.duzce.vtys.rentacar.exception.CustomerAdressNotFoundException;
import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.model.CustomerAdress;
import com.duzce.vtys.rentacar.repository.CustomerAdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAdressService {

    private final CustomerAdressRepository customerAdressRepository;

    private final CustomerService customerService;

    private final CustomerAdressDtoConverter customerAdressDtoConverter;


    // Lazy anatation used for circular injection fix.
    public CustomerAdressService(CustomerAdressRepository customerAdressRepository, CustomerService customerService, CustomerAdressDtoConverter customerAdressDtoConverter) {
        this.customerAdressDtoConverter = customerAdressDtoConverter;
        this.customerAdressRepository = customerAdressRepository;
        this.customerService = customerService;
    }

    public CustomerAdress findCustomerAdressByAdressId(Long id) {
        return customerAdressRepository.findById(id).orElseThrow(
                () -> new CustomerAdressNotFoundException("Customer Adress Could not find by id: " + id.toString()));
    }


    public List<CustomerAdressDto> getCustomerAdressByCustomerId(Long id) {
        return new CustomerAdressDtoConverter()
                .convert(customerAdressRepository.getCustomerAdressByCustomerId(id));

    }

    public CustomerAdressDto getCustomerAdressByAdressId(Long id) {
        return customerAdressDtoConverter
                .convert(customerAdressRepository.findById(id).orElseThrow(
                        () -> new CustomerAdressNotFoundException("Customer Adress Could not find by id: " + id.toString())));

    }

    public List<CustomerAdressDto> getAllCustomerAdress() {
        return customerAdressDtoConverter.convert(customerAdressRepository.findAll());
    }

    public CustomerAdressDto postCustomerAdress(CustomerAdress customerAdress) {
        Customer customer = customerService.findCustomerById(customerAdress.getCustomer().getCustomerId());
        customerAdress.setCustomer(customer);
        customerAdressRepository.save(customerAdress);
        return customerAdressDtoConverter.convert(customerAdress);
    }

    public CustomerAdressDto deleteCustomerAdressByAdressId(Long id) {
        CustomerAdress customerAdress = findCustomerAdressByAdressId(id);
        customerAdressRepository.deleteById(id);
        return customerAdressDtoConverter.convert(customerAdress);
    }


}



