package com.shikbeTumio.vehicledetails.api.vehicledetails.dto;

import com.shikbeTumio.vehicledetails.api.vehicledetails.entity.VehicleDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDetailsDTO {
    List<VehicleDetails> vehicleDetailsList;
}
