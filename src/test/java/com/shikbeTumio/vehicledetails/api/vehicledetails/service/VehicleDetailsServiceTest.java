package com.shikbeTumio.vehicledetails.api.vehicledetails.service;

import com.shikbeTumio.vehicledetails.api.vehicledetails.dao.VehicleDetailsDAO;
import com.shikbeTumio.vehicledetails.api.vehicledetails.entity.VehicleDetails;
import com.shikbeTumio.vehicledetails.api.vehicledetails.exception.VehicleDetailsNotFound;
import com.shikbeTumio.vehicledetails.api.vehicledetails.exception.VehicleNotSaved;
import com.shikbeTumio.vehicledetails.api.vehicledetails.service.impl.VehicleDetailsServiceImpl;
import org.assertj.core.api.AssertJProxySetup;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class VehicleDetailsServiceTest {

    VehicleDetails vehicleDetails;
    @Mock
    private VehicleDetailsDAO vehicleDetailsDAO;
    @InjectMocks
    private VehicleDetailsServiceImpl vehicleDetailsService;

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
    @DisplayName("Test vehicle details saved when passed valid input data")
    void saved_VehicleDetails() throws VehicleNotSaved {
        Mockito.when(vehicleDetailsDAO.save(Mockito.any(VehicleDetails.class))).thenReturn(vehicleDetails);
        VehicleDetails output = vehicleDetailsService.saveVehicleDetails(vehicleDetails);
        Assertions.assertThat(output).isNotNull();
    }

    @Test
    void fetchAll_VehicleDetails() {
        VehicleDetails vehicleDetails2 = VehicleDetails.builder()
                .modelYear(2022)
                .brandName("Toyota")
                .modelName("Camry")
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
        VehicleDetails vehicleDetails3 = VehicleDetails.builder()
                .modelYear(2021)
                .brandName("Toyota")
                .modelName("Corolla")
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

        List<VehicleDetails> input = Arrays.asList(vehicleDetails, vehicleDetails2, vehicleDetails3);
        Mockito.when(vehicleDetailsDAO.findAll()).thenReturn(input);
        List<VehicleDetails> output = vehicleDetailsDAO.findAll();
        Assertions.assertThat(output).isNotNull();
        Assertions.assertThat(output.size()).isEqualTo(3);
    }
    @Test
    void getVehicle_By_IDTest() throws VehicleDetailsNotFound {
        VehicleDetails dbVehicleDetails = new VehicleDetails(105, 2020, "Volkswagen", "Arteon", "SE", "Sedan", 64496.759, 1500, 2.16, "Perth, Australia", "The Volkswagen Arteon is a car manufactured by German car manufacturer Volkswagen.Described as a large family car or a mid-size car, it is available in five-door liftback or estate body styles.", "Nexus Motor Ltd", "+880185365127");
        //vehicleDetailsDAO.save(vehicleDetails);
        Mockito.when(vehicleDetailsDAO.findById(105)).thenReturn(Optional.of(dbVehicleDetails));
        VehicleDetails savedVehicleDetails = vehicleDetailsService.getVehicleById(105);
        Assertions.assertThat(savedVehicleDetails).isNotNull();
    }
}