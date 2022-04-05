package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.dto.CustomerLoginDto;

import com.duzce.vtys.rentacar.service.CustomerLoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customerLogin")
public class CustomerLoginController {
    private final CustomerLoginService customerLoginService;


    public CustomerLoginController(CustomerLoginService customerLoginService) {
        this.customerLoginService = customerLoginService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerLoginDto>> getAllCustomerLogin (){
        return ResponseEntity.ok(customerLoginService.getAllCustomerLogin());
    }
}
