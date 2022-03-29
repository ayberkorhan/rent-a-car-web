package com.duzce.vtys.rentacar.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identity_number")
    private Long identityNumber;

    @Column(name = "birhday")
    private Date birthday;

    @Column(name = "created_date")
    private Date cratedDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "adressID", nullable = false)
    private CustomerAdress customerAdress;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="loginID")
    private CustomerLogin customerLogin;


}
