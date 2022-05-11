package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.dto.driver.DriverLicenceDto;
import com.duzce.vtys.rentacar.model.DriverLicence;
import com.duzce.vtys.rentacar.service.DriverLicenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/driverlicence")
public class DriverLicenceController {

    private final DriverLicenceService driverLicenceService;

    public DriverLicenceController(DriverLicenceService driverLicenceService) {
        this.driverLicenceService = driverLicenceService;
    }


    @GetMapping()
    public ResponseEntity<List<DriverLicence>> getAllDriverLicence(){
        return ResponseEntity.ok(driverLicenceService.getAllDriverLicence());
    }

    @PostMapping() ResponseEntity<DriverLicenceDto> postDriverLicence(@RequestBody DriverLicence driverLicence){
        return ResponseEntity.ok(driverLicenceService.addNewDriverLicence(driverLicence));
    }

}
