package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.dto.CustomerAdressDto;
import com.duzce.vtys.rentacar.dto.CustomerAdressDtoConverter;
import com.duzce.vtys.rentacar.dto.CustomerDto;
import com.duzce.vtys.rentacar.dto.CustomerDtoConverter;
import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.model.CustomerAdress;
import com.duzce.vtys.rentacar.service.CustomerAdressService;
import com.duzce.vtys.rentacar.service.CustomerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerAdressService customerAdressService;

    public CustomerController(CustomerService customerService, CustomerAdressService customerAdressService) {
        this.customerService = customerService;
        this.customerAdressService = customerAdressService;
    }

    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getAllCustomer() throws Exception {
        return Respon   seEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/adres/{id}")
    public ResponseEntity<List<CustomerAdress>> getCustomerAdressByCustomerId() throws Exception {
        return ResponseEntity.ok(customerAdressService.getCustomerAdressByCustomerId(3L));
    }

}
