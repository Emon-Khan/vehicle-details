package com.shikbeTumio.vehicledetails.api.vehicledetails.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shikbeTumio.vehicledetails.api.vehicledetails.dao.VehicleDetailsDAO;
import com.shikbeTumio.vehicledetails.api.vehicledetails.entity.VehicleDetails;
import com.shikbeTumio.vehicledetails.api.vehicledetails.exception.VehicleDetailsNotFound;
import com.shikbeTumio.vehicledetails.api.vehicledetails.service.VehicleDetailsService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = VehicleDetailsController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class VehicleDetailsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private VehicleDetailsService vehicleDetailsService;
    @Autowired
    private ObjectMapper objectMapper;

    private VehicleDetails vehicleDetails;
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
    public void VehicleDetailsController_CreateVehicle_ReturnCreated() throws Exception {
        given(vehicleDetailsService.saveVehicleDetails(ArgumentMatchers.any())).willAnswer(invocation -> invocation.getArgument(0));
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/vehicle-details")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vehicleDetails)));
        response.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandName", CoreMatchers.is(vehicleDetails.getBrandName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.modelName", CoreMatchers.is(vehicleDetails.getModelName())));
    }

    @Test
    public void fetchAllVehicleDetails_ReturnOK() throws VehicleDetailsNotFound, Exception {
        List<VehicleDetails> output = Arrays.asList(
                new VehicleDetails(1, 2022, "Honda", "Camry", "LS", "", 25468.65, 1500, 5.35, "Albaquerque, New Mexico", "There is no defect in this car.Before purchasing you can check this car for a long period of time.", "DS Auto", "+8801967899852"),
                new VehicleDetails(2, 2020, "Toyota", "Camry", "LS", "", 25468.65, 1500, 5.35, "Albaquerque, New Mexico", "There is no defect in this car.Before purchasing you can check this car for a long period of time.", "DS Auto", "+8801967899852"),
                new VehicleDetails(2, 2020, "Toyota", "Camry", "LS", "", 25468.65, 1500, 5.35, "Albaquerque, New Mexico", "There is no defect in this car.Before purchasing you can check this car for a long period of time.", "DS Auto", "+8801967899852"));
        when(vehicleDetailsService.fetchAllVehicleDetails()).thenReturn(output);
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/vehicle-details")
                .contentType(MediaType.APPLICATION_JSON));
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].brandName").value("Honda"));
    }
}