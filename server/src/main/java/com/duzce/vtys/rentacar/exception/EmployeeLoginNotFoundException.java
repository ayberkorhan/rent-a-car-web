package com.duzce.vtys.rentacar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author mahmutcandurak
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeLoginNotFoundException extends RuntimeException {

    public EmployeeLoginNotFoundException(String message) {
        super(message);
    }
}
