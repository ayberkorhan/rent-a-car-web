package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.model.DriverLicence;
import org.springframework.stereotype.Component;

@Component
public class DriverLicenceDtoConverter {

    public DriverLicenceDto convert(DriverLicence driverLicence){
        return new DriverLicenceDto(
                driverLicence.getDriveLicenceId(),
                driverLicence.getLicenceType(),
                driverLicence.getTakenDate()
        );
    }
}
