package com.duzce.vtys.rentacar.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer_login")
public class CustomerLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id")
    private Long loginId;

    @Column(unique = true)
    private String email;

    @Column(name = "login_password")
    private String password;

    @Temporal(TemporalType.TIMESTAMP) // default date değeri
    private Date createdDate;

    @OneToOne(mappedBy = "customerLogin")
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

    public Date getCreatedDate() {
        return createdDate;
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
}
