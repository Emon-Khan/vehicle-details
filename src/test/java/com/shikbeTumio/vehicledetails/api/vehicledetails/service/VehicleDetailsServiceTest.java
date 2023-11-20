package com.shikbeTumio.vehicledetails.api.vehicledetails.service;

import com.shikbeTumio.vehicledetails.api.vehicledetails.dao.VehicleDetailsDAO;
import com.shikbeTumio.vehicledetails.api.vehicledetails.entity.VehicleDetails;
import com.shikbeTumio.vehicledetails.api.vehicledetails.exception.VehicleNotSaved;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class VehicleDetailsServiceTest {

    @MockBean
    private VehicleDetailsDAO vehicleDetailsDAO;
    @Autowired
    private VehicleDetailsService vehicleDetailsService;
    private VehicleDetails vehicleDetails;

    @BeforeEach
    void setUp() {
        vehicleDetails = new VehicleDetails();
        vehicleDetails.setId(1);
        vehicleDetails.setModelYear(2022);
        vehicleDetails.setBrandName("Toyota");
        vehicleDetails.setModelName("Camry");
        vehicleDetails.setTrimType("LS");
        vehicleDetails.setBodyType("coupe");
        vehicleDetails.setVehiclePrice(26548.20);
        vehicleDetails.setMilesOnVehicle(1100);
        vehicleDetails.setInterestRate(3.5);
        vehicleDetails.setLocationOfVehicle("Mirpur,Dhaka,Bangladesh");
        vehicleDetails.setVehicleDescription("There is no defect in this car.Before purchasing you can check this car for a long period of time.");
        vehicleDetails.setSellerName("Navana Autos");
        vehicleDetails.setSellerContactNumber("+8801725862487");

    }

    @Test
    @DisplayName("Test vehicle details saved when passed valid input data")
    void saveVehicleDetails() throws VehicleNotSaved {
        VehicleDetails input = new VehicleDetails();
        input.setId(1);
        input.setModelYear(2022);
        input.setBrandName("Toyota");
        input.setModelName("Camry");
        input.setTrimType("LS");
        input.setBodyType("coupe");
        input.setVehiclePrice(26548.20);
        input.setMilesOnVehicle(1100);
        input.setInterestRate(3.5);
        input.setLocationOfVehicle("Mirpur,Dhaka,Bangladesh");
        input.setVehicleDescription("There is no defect in this car.Before purchasing you can check this car for a long period of time.");
        input.setSellerName("Navana Autos");
        input.setSellerContactNumber("+8801725862487");

        Mockito.when(vehicleDetailsDAO.save(input)).thenReturn(vehicleDetails);
        VehicleDetails output = vehicleDetailsService.saveVehicleDetails(input);
        assertEquals(output.getId(), vehicleDetails.getId());
        assertEquals(output.getModelYear(), vehicleDetails.getModelYear());
        assertEquals(output.getBrandName(), vehicleDetails.getBrandName());
    }
}