package com.shikbeTumio.vehicledetails.api.vehicledetails.dao;

import com.shikbeTumio.vehicledetails.api.vehicledetails.entity.VehicleDetails;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class VehicleDetailsDAOTest {
    @Autowired
    private VehicleDetailsDAO vehicleDetailsDAO;

    @Test
    public void VehicleDetails_Save_ReturnedSavedVehicleDetails() {
        //Arrange
        VehicleDetails vehicleDetails = VehicleDetails.builder()
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

        //Act
        VehicleDetails savedVehicleDetails = vehicleDetailsDAO.save(vehicleDetails);

        //Assert
        Assertions.assertThat(savedVehicleDetails).isNotNull();
        //Assertions.assertThat(savedVehicleDetails.getId()).isGreaterThan(0);
    }

}