package com.duzce.vtys.rentacar.service;


import com.duzce.vtys.rentacar.exception.CarNotFoundException;
import com.duzce.vtys.rentacar.model.Car;
import com.duzce.vtys.rentacar.model.CarInfo;
import com.duzce.vtys.rentacar.repository.CarInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CarInfoService {

    private final CarInfoRepository carInfoRepository;

    public CarInfoService(CarInfoRepository carInfoRepository) {
        this.carInfoRepository = carInfoRepository;
    }

    public CarInfo saveCarInfo(CarInfo carInfo) {
        return carInfoRepository.save(carInfo);
    }

    public CarInfo findCarInfoByCarId(Long id) {
        return carInfoRepository.findById(id).orElseThrow(() -> new CarNotFoundException("CarInfo could not find by id: " + id.toString()));
    }

    public CarInfo getCarInfoById(Long id ){
        return carInfoRepository.findById(id).orElseThrow(() -> new CarNotFoundException("CarInfo could not find by id: " + id.toString()));
    }

    public List<CarInfo> getAllCarInfos() {
        return carInfoRepository.findAll();
    }
}
