package com.duzce.vtys.rentacar.model;

import javax.persistence.*;


@Entity
@Table(name = "customer_login")
public class CustomerLogin {

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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoginId(Long loginId) {this.loginId = loginId;}
}
