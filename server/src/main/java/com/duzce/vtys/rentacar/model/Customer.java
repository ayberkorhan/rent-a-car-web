package com.duzce.vtys.rentacar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    public Customer() {}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identity_number",unique = true)
    private Long identityNumber;

    @OneToMany(mappedBy = "adressId", fetch = FetchType.LAZY)
    private List<CustomerAdress> customerAdress;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<DriverLicence> driverLicence;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "login_id", unique = true)
    private CustomerLogin customerLogin;

    public CustomerLogin getCustomerLogin() {
        return customerLogin;
    }

    public void setCustomerLogin(CustomerLogin customerLogin) {
        this.customerLogin = customerLogin;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerID) {
        this.customerId = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(Long identityNumber) {
        this.identityNumber = identityNumber;
    }



}
