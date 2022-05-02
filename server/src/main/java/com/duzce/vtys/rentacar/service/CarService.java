package com.duzce.vtys.rentacar.service;

import com.duzce.vtys.rentacar.dto.CarDto;
import com.duzce.vtys.rentacar.dto.CarDtoConverter;
import com.duzce.vtys.rentacar.dto.CustomerDto;
import com.duzce.vtys.rentacar.exception.CarNotFoundException;
import com.duzce.vtys.rentacar.exception.CustomerNotFoundException;
import com.duzce.vtys.rentacar.model.Car;
import com.duzce.vtys.rentacar.model.CarInfo;
import com.duzce.vtys.rentacar.model.CarLocation;
import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarInfoService carInfoService;
    private final CarLocationService carLocationService;
    private final CarRepository carRepository;
    private final CarDtoConverter carDtoConverter;

    public CarService(CarInfoService carInfoService, CarLocationService carLocationService, CarRepository carRepository, CarDtoConverter carDtoConverter) {
        this.carInfoService = carInfoService;
        this.carLocationService = carLocationService;
        this.carRepository = carRepository;
        this.carDtoConverter = carDtoConverter;
    }

    public CarDto saveCar(Car car, CarInfo carInfo, CarLocation carLocation) {
        carInfo=carInfoService.saveCarInfo(carInfo);
        carLocation=carLocationService.saveCarLocation(carLocation);
        car.setCarInfo(carInfo);
        car.setCarLocation(carLocation);
        carRepository.save(car);
        return carDtoConverter.convert(car,carInfo,carLocation);
    }

    public boolean deleteCarById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            carRepository.deleteById(id);
            return true;
        } else {
            throw new CarNotFoundException("Car could not find by id: " + id.toString());
        }
    }

    public List<Car> getAll() {
        return carRepository.findAll();

    }

    public Car saveAll(Car car){
        return carRepository.save(car);
    }


    protected Car findCarById(Long id) throws CustomerNotFoundException {
        return carRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer could not find by id: " + id.toString())
        );
    }
    ;

}
