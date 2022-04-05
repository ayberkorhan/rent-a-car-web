package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.service.CustomerLogin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerLogin customerService;

    public CustomerController(CustomerLogin customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Customer>> getAllCustomer() throws Exception {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
    @GetMapping("/hello")
    public String helloWorld (){
        return "Hello from API";
    }
}
