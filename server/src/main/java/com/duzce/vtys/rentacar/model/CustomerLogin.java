package com.duzce.vtys.rentacar.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name= "customer_login")
public class CustomerLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loginID;

    @Column(name="email",unique = true)
    private String email;

    @Column(name="customer_password")
    private String customerPassword;

    @Column(name="created_date")
    private Date createdDate;

    @OneToOne(mappedBy = "customerLogin")
    private Customer customer;


}
