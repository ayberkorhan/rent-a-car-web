/**
 *
 * @author enescyc
 * @author mahmutcandurak
 *
 */

package com.duzce.vtys.rentacar.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer_adress")
public class CustomerAdress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adressID;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "town")
    private String town;

    @Column(name = "street")
    private String street;

    @Column(name = "building_info" , length = 22)
    private String buildingInfo; // db de tipler düzeltilecek

    @Column(name = "door_number")
    private String doorNumber;  // db de tipler düzeltilecek

    @Column(name = "zip_code")
    private String zipCode; // db de tipler düzeltilecek


    @OneToMany(mappedBy = "customerAdress", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Customer> pages;


}
