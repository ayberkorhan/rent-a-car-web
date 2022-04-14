package com.duzce.vtys.rentacar.service;

import com.duzce.vtys.rentacar.exception.CarNotFoundException;
import com.duzce.vtys.rentacar.model.CarLocation;
import com.duzce.vtys.rentacar.repository.CarLocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarLocationService {

    private final CarLocationRepository carLocationRepository;

    public CarLocationService(CarLocationRepository carLocationRepository) {
        this.carLocationRepository = carLocationRepository;
    }

    public CarLocation saveCarLocation(CarLocation carLocation) {
        return carLocationRepository.save(carLocation);
    }


    public CarLocation findCarLocationById(Long id) {
        return carLocationRepository.findById(id).orElseThrow(
                () -> new CarNotFoundException("CarLocation could not find by id: " + id.toString()));
    }
    public List<CarLocation> getAllCarLocation(){
        return carLocationRepository.findAll();
    }
}
