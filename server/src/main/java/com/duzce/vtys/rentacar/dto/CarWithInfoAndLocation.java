package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.model.Car;
import com.duzce.vtys.rentacar.model.CarInfo;
import com.duzce.vtys.rentacar.model.CarLocation;

public class CarWithInfoAndLocation {
    private Car car;
    private CarInfo carInfo;
    private CarLocation carLocation;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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
