package com.duzce.vtys.rentacar.exception;

import com.duzce.vtys.rentacar.model.DriverLicence;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DriverLicenceNotFoundException extends RuntimeException{
    public DriverLicenceNotFoundException(String message){
        super(message);
    }
}
