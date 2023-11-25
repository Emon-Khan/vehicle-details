package com.shikbeTumio.vehicledetails.api.vehicledetails.controller;

import com.shikbeTumio.vehicledetails.api.vehicledetails.entity.VehicleDetails;
import com.shikbeTumio.vehicledetails.api.vehicledetails.exception.MandatoryFieldMissingException;
import com.shikbeTumio.vehicledetails.api.vehicledetails.exception.VehicleDetailsNotFound;
import com.shikbeTumio.vehicledetails.api.vehicledetails.service.VehicleDetailsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle-details")
public class VehicleDetailsController {
    @Autowired
    VehicleDetailsService vehicleDetailsService;
    @PostMapping
    public ResponseEntity<VehicleDetails>saveVehicle(@Valid @RequestBody VehicleDetails vehicleDetails, BindingResult result) throws Exception {
        if(result.hasErrors()){
            List<ObjectError> errorList = result.getAllErrors();
            String allErrors = "";
            for(ObjectError err: errorList){
                allErrors+=err.getDefaultMessage()+",";
            }
            throw new MandatoryFieldMissingException(allErrors);
        }
        VehicleDetails saveVehicleInfo =  vehicleDetailsService.saveVehicleDetails(vehicleDetails);
        return new ResponseEntity<>(saveVehicleInfo, HttpStatus.CREATED);
    }
    @GetMapping
    public List<VehicleDetails> getAllVehicleDetails() throws VehicleDetailsNotFound {
        return vehicleDetailsService.fetchAllVehicleDetails();
    }
}
