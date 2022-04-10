package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.dto.CustomerDto;
import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.model.CustomerAdress;
import com.duzce.vtys.rentacar.service.CustomerAdressService;
import com.duzce.vtys.rentacar.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


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
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDto> deleteCustomerById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(customerService.deleteCustomerById(id));
    }

    @PostMapping()
    public ResponseEntity<CustomerDto> createNewCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

}
