package com.shikbeTumio.vehicledetails.api.vehicledetails.service;

import com.shikbeTumio.vehicledetails.api.vehicledetails.dao.VehicleDetailsDAO;
import com.shikbeTumio.vehicledetails.api.vehicledetails.entity.VehicleDetails;
import com.shikbeTumio.vehicledetails.api.vehicledetails.exception.VehicleNotSaved;
import com.shikbeTumio.vehicledetails.api.vehicledetails.service.impl.VehicleDetailsServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class VehicleDetailsServiceTest {

    @Mock
    private VehicleDetailsDAO vehicleDetailsDAO;
    @InjectMocks
    private VehicleDetailsServiceImpl vehicleDetailsService;

    @Test
    @DisplayName("Test vehicle details saved when passed valid input data")
    void saved_VehicleDetails() throws VehicleNotSaved {
        VehicleDetails vehicleDetails = VehicleDetails.builder()
        .modelYear(2022)
        .brandName("Toyota")
        .modelName("Camry")
        .trimType("LS")
        .bodyType("coupe")
        .vehiclePrice(26548.20)
        .milesOnVehicle(1100)
        .interestRate(3.5)
        .locationOfVehicle("Mirpur,Dhaka,Bangladesh")
        .vehicleDescription("There is no defect in this car.Before purchasing you can check this car for a long period of time.")
        .sellerName("Navana Autos")
        .sellerContactNumber("+8801725862487").build();

        Mockito.when(vehicleDetailsDAO.save(Mockito.any(VehicleDetails.class))).thenReturn(vehicleDetails);
        VehicleDetails output = vehicleDetailsService.saveVehicleDetails(vehicleDetails);
        Assertions.assertThat(output).isNotNull();
    }
}