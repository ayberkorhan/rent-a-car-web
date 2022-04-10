package com.duzce.vtys.rentacar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerAdressNotFoundException extends RuntimeException{
    public CustomerAdressNotFoundException(String message) {
        super(message);
    }
}
