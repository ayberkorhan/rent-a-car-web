package com.duzce.vtys.rentacar.model;


import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long carId;

    @Column(name = "plate", unique = true)
    String plate;

    @Column(name = "car_class")
    String carClass;

    @Column(name = "fuel_type")
    String fuelType;

    @Column(name = "gear_type")
    String gearType;

}
