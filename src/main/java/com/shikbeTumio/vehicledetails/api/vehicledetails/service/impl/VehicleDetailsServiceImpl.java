package com.shikbeTumio.vehicledetails.api.vehicledetails.service.impl;

import com.shikbeTumio.vehicledetails.api.vehicledetails.dao.VehicleDetailsDAO;
import com.shikbeTumio.vehicledetails.api.vehicledetails.entity.VehicleDetails;
import com.shikbeTumio.vehicledetails.api.vehicledetails.exception.VehicleDetailsNotFound;
import com.shikbeTumio.vehicledetails.api.vehicledetails.exception.VehicleNotSaved;
import com.shikbeTumio.vehicledetails.api.vehicledetails.service.VehicleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleDetailsServiceImpl implements VehicleDetailsService {
    @Autowired
    private VehicleDetailsDAO vehicleDetailsDao;

    @Override
    public VehicleDetails saveVehicleDetails(VehicleDetails vehicleDetails) throws VehicleNotSaved {
        VehicleDetails dbVehicleDetails = null;
        try {
            dbVehicleDetails = vehicleDetailsDao.save(vehicleDetails);
        } catch (Exception ex) {
            throw new VehicleNotSaved("Unable to save vehicle in DB.Got error " + ex.getMessage());
        }
        return dbVehicleDetails;
    }

    @Override
    public List<VehicleDetails> fetchAllVehicleDetails() throws VehicleDetailsNotFound {
        List<VehicleDetails> dbVehicles = vehicleDetailsDao.findAll();
        if(dbVehicles.size()==0){
            throw new VehicleDetailsNotFound("No vehicle details found in Database!");
        }
        return dbVehicles;
    }
}
