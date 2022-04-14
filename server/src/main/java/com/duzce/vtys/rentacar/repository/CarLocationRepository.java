package com.duzce.vtys.rentacar.repository;

import com.duzce.vtys.rentacar.model.CarLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarLocationRepository extends JpaRepository<CarLocation,Long> {

}
