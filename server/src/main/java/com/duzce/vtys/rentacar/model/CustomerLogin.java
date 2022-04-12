package com.duzce.vtys.rentacar.model;

import javax.persistence.*;


@Entity
@Table(name = "customer_login")
public class CustomerLogin {

    public CustomerLogin(){}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "login_id")
    private Long loginId;

    @Column(unique = true)
    private String email;

    @Column(name = "login_password")
    private String password;

    @OneToOne(mappedBy = "customerLogin",fetch = FetchType.LAZY)
    private Customer customer;


    //Getter and Setter Methods

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
