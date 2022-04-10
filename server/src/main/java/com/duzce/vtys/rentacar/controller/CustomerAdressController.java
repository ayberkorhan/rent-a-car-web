package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.dto.CustomerAdressDto;
import com.duzce.vtys.rentacar.model.CustomerAdress;
import com.duzce.vtys.rentacar.service.CustomerAdressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/customeradress")
public class CustomerAdressController {

    private final CustomerAdressService customerAdressService;

    public CustomerAdressController(CustomerAdressService customerAdressService) {
        this.customerAdressService = customerAdressService;
    }

    @GetMapping("/customer/{id}") // customerID
    public ResponseEntity<List<CustomerAdressDto>> getCustomerAdressByCustomerId(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(customerAdressService.getCustomerAdressByCustomerId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerAdressDto> getCustomerAdressByAdressId(@PathVariable Long id) {
        return ResponseEntity.ok(customerAdressService.getCustomerAdressByAdressId(id));
    }

    @GetMapping()
    public ResponseEntity<List<CustomerAdressDto>> getAllCustomerAdress() {
        return ResponseEntity.ok(customerAdressService.getAllCustomerAdress());
    }

    @PostMapping()
    public ResponseEntity<CustomerAdressDto> postCustomerAdress(@RequestBody CustomerAdress customerAdress) throws Exception {
        return ResponseEntity.ok(customerAdressService.postCustomerAdress(customerAdress));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerAdressDto> deleteCustomerAdressByAdressId(@PathVariable Long id){
        return ResponseEntity.ok(customerAdressService.deleteCustomerAdressByAdressId(id));
    }


}
