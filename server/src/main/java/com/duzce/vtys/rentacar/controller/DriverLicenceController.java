package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.dto.DriverLicenceDto;
import com.duzce.vtys.rentacar.model.DriverLicence;
import com.duzce.vtys.rentacar.service.DriverLicenceService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
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
