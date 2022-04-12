package com.duzce.vtys.rentacar.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Car implements Serializable {

    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long carId;

    @Column(unique = true)
    private String plate;

    private String carClass;

    private String fuelType;

    private String gearType;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "car_info_id",unique = true)
    private CarInfo carInfo;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "car_location_id",unique = true)
    private CarLocation carLocation;

    //Getter and Setter Methods


    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public CarInfo getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(CarInfo carInfo) {
        this.carInfo = carInfo;
    }

    public CarLocation getCarLocation() {
        return carLocation;
    }

    public void setCarLocation(CarLocation carLocation) {
        this.carLocation = carLocation;
    }
}
