package com.shikbeTumio.vehicledetails.api.vehicledetails.dao;

import com.shikbeTumio.vehicledetails.api.vehicledetails.entity.VehicleDetails;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class VehicleDetailsDAOTest {
    VehicleDetails vehicleDetails;
    @Autowired
    private VehicleDetailsDAO vehicleDetailsDAO;

    @BeforeEach
    public void init() {
        vehicleDetails = VehicleDetails.builder()
                .modelYear(2020)
                .brandName("Volkswagen")
                .modelName("Arteon")
                .trimType("SE")
                .bodyType("Sedan")
                .vehiclePrice(64496.759)
                .milesOnVehicle(1500)
                .interestRate(2.16)
                .locationOfVehicle("Perth, Australia")
                .vehicleDescription("The Volkswagen Arteon is a car manufactured by German car manufacturer Volkswagen.\n" +
                        "Described as a large family car or a mid-size car, it is available in five-door \n" +
                        "liftback or estate body styles.")
                .sellerName("Nexus Motors Ltd")
                .sellerContactNumber("+880185365127").build();
    }

    @Test
    public void VehicleDetails_Save_ReturnedSavedVehicleDetails() {
        //Arrange
        //This part has been writen on the @BeforeEach section so that i can use it whenever i want
        //Act
        VehicleDetails savedVehicleDetails = vehicleDetailsDAO.save(vehicleDetails);

        //Assert
        Assertions.assertThat(savedVehicleDetails).isNotNull();
        Assertions.assertThat(savedVehicleDetails.getId()).isGreaterThan(0);
    }

    @Test
    public void getAllVehicleDetails() {
        //Arrange
        VehicleDetails vehicleDetails2 = VehicleDetails.builder()
                .modelYear(2022)
                .brandName("Toyota")
                .modelName("Camry")
                .trimType("LS")
                .bodyType("")
                .vehiclePrice(25468.65)
                .milesOnVehicle(1500)
                .interestRate(5.35)
                .locationOfVehicle("Albuquerque, New Mexico")
                .vehicleDescription("There is no defect in this car.Before purchasing you can check this car for a long period of time.")
                .sellerName("DS Auto")
                .sellerContactNumber("+8801967899852").build();


        vehicleDetailsDAO.save(vehicleDetails);
        vehicleDetailsDAO.save(vehicleDetails2);
        //Act
        List<VehicleDetails> getVehicleDetails = vehicleDetailsDAO.findAll();
        //Assert
        Assertions.assertThat(getVehicleDetails).isNotNull();
        Assertions.assertThat(getVehicleDetails.size()).isEqualTo(2);
    }

}