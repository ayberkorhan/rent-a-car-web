package com.duzce.vtys.rentacar.service;

import com.duzce.vtys.rentacar.dto.driver.DriverLicenceDto;
import com.duzce.vtys.rentacar.dto.driver.DriverLicenceDtoConverter;
import com.duzce.vtys.rentacar.exception.DriverLicenceNotFoundException;
import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.model.DriverLicence;
import com.duzce.vtys.rentacar.repository.DriveLicenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverLicenceService {

    private final DriveLicenceRepository driveLicenceRepository;

    private final CustomerService customerService;

    private final DriverLicenceDtoConverter driverLicenceDtoConverter;

    public DriverLicenceService(DriveLicenceRepository driveLicenceRepository, CustomerService customerService, DriverLicenceDtoConverter driverLicenceDtoConverter) {
        this.driveLicenceRepository = driveLicenceRepository;
        this.customerService = customerService;
        this.driverLicenceDtoConverter = driverLicenceDtoConverter;
    }

    public List<DriverLicence> getAllDriverLicence() {
        return driveLicenceRepository.findAll();
    }

    public DriverLicence getDriverLicenceById(Long id) {
        return driveLicenceRepository.findById(id).orElseThrow(
                () -> new DriverLicenceNotFoundException("Could Not Found Driver Licence By Id :" + id.toString()));
    }

    public DriverLicence findDriverLicenceById(Long id) {
        return driveLicenceRepository.findById(id)
                .orElseThrow
                        (() -> new DriverLicenceNotFoundException("Could not found driver license by id:" +id.toString()));
    }

    public DriverLicenceDto addNewDriverLicence(DriverLicence driverLicence) {
        Customer customer = customerService.findCustomerById(driverLicence.getCustomer().getCustomerId());
        driverLicence.setCustomer(customer);
        return driverLicenceDtoConverter.convert(driveLicenceRepository.save(driverLicence));
    }

    public DriverLicenceDto deleteDriverLicenceById(Long id) {
        DriverLicence driverLicence = findDriverLicenceById(id);
        driveLicenceRepository.deleteById(id);
        return driverLicenceDtoConverter.convert(driverLicence);
    }


}
