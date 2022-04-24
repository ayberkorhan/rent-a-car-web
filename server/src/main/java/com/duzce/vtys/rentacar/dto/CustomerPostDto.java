package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.model.CustomerAdress;
import com.duzce.vtys.rentacar.model.CustomerLogin;

public class CustomerPostDto {

    public CustomerPostDto() {}

    CustomerLogin customerLogin;
    Customer customer;
    CustomerAdress customerAdress;

    public CustomerPostDto(CustomerLogin customerLogin, Customer customer, CustomerAdress customerAdress) {
        this.customerLogin = customerLogin;
        this.customer = customer;
        this.customerAdress = customerAdress;
    }

    public CustomerLogin getCustomerLogin() {
        return customerLogin;
    }

    public void setCustomerLogin(CustomerLogin customerLogin) {
        this.customerLogin = customerLogin;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerAdress getCustomerAdress() {
        return customerAdress;
    }

    public void setCustomerAdress(CustomerAdress customerAdress) {
        this.customerAdress = customerAdress;
    }


}
