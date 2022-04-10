package com.duzce.vtys.rentacar.exception;

public class CustomerLoginNotFoundException extends NullPointerException{
    public CustomerLoginNotFoundException() {
        new CustomerLoginNotFoundException("Kullanıcı Bulunmadı");
    }

    public CustomerLoginNotFoundException(String s) {
        super(s);
    }
}
