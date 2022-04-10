package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.model.CustomerAdress;
import com.duzce.vtys.rentacar.service.CustomerAdressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/customeradres")
public class CustomerAdressController {

    private final CustomerAdressService customerAdressService;

    public CustomerAdressController(CustomerAdressService customerAdressService) {
        this.customerAdressService = customerAdressService;
    }



    @GetMapping("/{id}")
    public ResponseEntity<List<CustomerAdress>> getCustomerAdressByCustomerId() throws Exception {
        return ResponseEntity.ok(customerAdressService.getCustomerAdressByCustomerId(3L));
    }

}
