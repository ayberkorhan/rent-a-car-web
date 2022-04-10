package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.dto.CustomerLoginDto;
import com.duzce.vtys.rentacar.model.CustomerLogin;
import com.duzce.vtys.rentacar.service.CustomerLoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customerlogin")
public class CustomerLoginController {
    private final CustomerLoginService customerLoginService;


    public CustomerLoginController(CustomerLoginService customerLoginService) {
        this.customerLoginService = customerLoginService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerLoginDto>> getAllCustomerLogin (){
        return ResponseEntity.ok(customerLoginService.getAllCustomerLogin());
    }

    @PostMapping()
    public ResponseEntity<CustomerLoginDto> postCustomerLogin(@RequestBody CustomerLogin customerLogin){
        return ResponseEntity.ok(customerLoginService.save(customerLogin));
    }
}
