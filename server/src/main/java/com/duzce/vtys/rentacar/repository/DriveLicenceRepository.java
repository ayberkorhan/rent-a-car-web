package com.duzce.vtys.rentacar.repository;

import com.duzce.vtys.rentacar.model.DriverLicence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriveLicenceRepository extends JpaRepository<DriverLicence,Long> {
}
