package com.duzce.vtys.rentacar.model;


import javax.persistence.*;

@Entity
public class CarInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String carModel;
    private String carName;
    private String carYear;
    private String carKilometer;

}
