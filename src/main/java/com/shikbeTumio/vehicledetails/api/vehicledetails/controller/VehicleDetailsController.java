package com.shikbeTumio.vehicledetails.api.vehicledetails.controller;

import com.shikbeTumio.vehicledetails.api.vehicledetails.entity.VehicleDetails;
import com.shikbeTumio.vehicledetails.api.vehicledetails.service.VehicleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehicle-details")
public class VehicleDetailsController {
    @Autowired
    VehicleDetailsService vehicleDetailsService;
    @PostMapping
    public ResponseEntity<VehicleDetails>saveVehicle(@RequestBody VehicleDetails vehicleDetails){
        VehicleDetails saveVehicleInfo =  vehicleDetailsService.saveVehicleDetails(vehicleDetails);
        return new ResponseEntity<>(saveVehicleInfo, HttpStatus.CREATED);
    }
}
