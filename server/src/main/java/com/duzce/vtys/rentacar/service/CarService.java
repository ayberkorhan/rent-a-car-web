package com.duzce.vtys.rentacar.service;

import com.duzce.vtys.rentacar.dto.car.CarDto;
import com.duzce.vtys.rentacar.dto.car.CarDtoConverter;
import com.duzce.vtys.rentacar.exception.CarNotFoundException;
import com.duzce.vtys.rentacar.model.Car;
import com.duzce.vtys.rentacar.model.CarInfo;
import com.duzce.vtys.rentacar.model.CarLocation;
import com.duzce.vtys.rentacar.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        carInfo = carInfoService.saveCarInfo(carInfo);
        carLocation = carLocationService.saveCarLocation(carLocation);
        car.setCarInfo(carInfo);
        car.setCarLocation(carLocation);
        carRepository.save(car);
        return carDtoConverter.convert(car, carInfo, carLocation);
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

    public CarDto getCarById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Car could not found by id: " + id.toString()));
        CarInfo carInfo = carInfoService.findCarInfoByCarId(car.getCarInfo().getCarInfoId());
        CarLocation carLocation = carLocationService.findCarLocationById(car.getCarLocation().getCarLocationId());
        return carDtoConverter.convert(car, carInfo, carLocation);

    }

    public List<CarDto> getAllCarsWithDetail() {
        List<Car> cars = carRepository.findAll();
        List<CarDto> carDtos = new ArrayList<>(cars.size());

        cars.stream().forEach(car -> {
            int i = 1;
            CarInfo carInfo = carInfoService.getCarInfoById(car.getCarInfo().getCarInfoId());
            CarLocation carLocation = carLocationService.findCarLocationById(car.getCarLocation().getCarLocationId());
            CarDto carDto = new CarDto(
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
                    carLocation.getLongitude());
            System.out.println(carDto);
            carDtos.add(carDto);
            i++;
        });

        return carDtos;
    }

}
