package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.model.Car;
import com.duzce.vtys.rentacar.model.CarInfo;
import com.duzce.vtys.rentacar.model.CarLocation;
import com.duzce.vtys.rentacar.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CarDtoConverter {

    public CarDto convert(Car car, CarInfo carInfo , CarLocation carLocation){
        return new CarDto(
                car.getCarId(),
                carInfo.getCarInfoId(),
                carLocation.getCarLocationId(),
                car.getPlate(),
                car.getCarClass(),
                car.getFuelType(),
                car.getGearType(),
                carInfo.getBrand(),
                carInfo.getModel(),
                carInfo.getYear(),
                carInfo.getKilometer(),
                carLocation.getLatitude(),
                carLocation.getLongitude()
                );
    }
    public CarDto convert(Car car) {
        return new CarDto(car.getCarId(),
                car.getPlate(),
                car.getCarClass(),
                car.getFuelType());
    }


}
