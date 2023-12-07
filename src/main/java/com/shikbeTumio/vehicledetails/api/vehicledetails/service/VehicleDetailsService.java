package com.shikbeTumio.vehicledetails.api.vehicledetails.service;

import com.shikbeTumio.vehicledetails.api.vehicledetails.entity.VehicleDetails;
import com.shikbeTumio.vehicledetails.api.vehicledetails.exception.VehicleDetailsNotFound;
import com.shikbeTumio.vehicledetails.api.vehicledetails.exception.VehicleNotSaved;

import java.util.List;

public interface VehicleDetailsService {
    VehicleDetails saveVehicleDetails(VehicleDetails vehicleDetails) throws VehicleNotSaved;

    List<VehicleDetails> fetchAllVehicleDetails() throws VehicleDetailsNotFound;

    VehicleDetails getVehicleById(int vehicleId) throws VehicleDetailsNotFound;

    void deleteVehicleDetailsById(int vehicleId) throws VehicleDetailsNotFound;

    VehicleDetails updateVehicleDetails(int vehicleId, VehicleDetails vehicleDetails) throws VehicleDetailsNotFound;
    List<VehicleDetails> fetchFilteredVehicleDetails(int modelYear, String brand, String model, String trim, double price) throws VehicleDetailsNotFound;
}
