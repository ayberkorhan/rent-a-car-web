package com.duzce.vtys.rentacar.dto;


import com.duzce.vtys.rentacar.model.CustomerAdress;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerAdressDtoConverter {
    
    public CustomerAdressDto convert(CustomerAdress customerAdress) {
        CustomerAdressDto customerAdressDto = new CustomerAdressDto(customerAdress.getCountry(),
                customerAdress.getCity(),
                customerAdress.getTown(),
                customerAdress.getStreet(),
                customerAdress.getBuildingInfo(),
                customerAdress.getDoorNumber(),
                customerAdress.getZipCode(),
                customerAdress.getCustomer().getCustomerId(),
                customerAdress.getAdressId()
        );
        return customerAdressDto;
        
    }


    public List<CustomerAdressDto> convert(List<CustomerAdress> CustomerAdress) {
        return CustomerAdress.stream()
                .map(customerAdress -> new CustomerAdressDto(
                        customerAdress.getCountry(),
                        customerAdress.getCity(),
                        customerAdress.getTown(),
                        customerAdress.getStreet(),
                        customerAdress.getBuildingInfo(),
                        customerAdress.getDoorNumber(),
                        customerAdress.getZipCode(),
                        customerAdress.getCustomer().getCustomerId(),
                        customerAdress.getAdressId()
                ))
                .collect(Collectors.toList());
    }





}
