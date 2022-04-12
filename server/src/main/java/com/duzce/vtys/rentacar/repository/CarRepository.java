package com.duzce.vtys.rentacar.repository;

import com.duzce.vtys.rentacar.dto.CarDto;
import com.duzce.vtys.rentacar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

}
