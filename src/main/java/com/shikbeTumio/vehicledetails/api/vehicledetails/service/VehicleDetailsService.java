package com.shikbeTumio.vehicledetails.api.vehicledetails.service;

import com.shikbeTumio.vehicledetails.api.vehicledetails.entity.VehicleDetails;
import com.shikbeTumio.vehicledetails.api.vehicledetails.exception.VehicleNotSaved;

public interface VehicleDetailsService {
    VehicleDetails saveVehicleDetails(VehicleDetails vehicleDetails) throws VehicleNotSaved;
}
