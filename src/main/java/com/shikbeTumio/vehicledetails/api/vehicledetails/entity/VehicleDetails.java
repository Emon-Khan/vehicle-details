package com.shikbeTumio.vehicledetails.api.vehicledetails.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="vehicle_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int modelYear;
    private String brandName;
    private String modelName;
    private String trimType;
    private String bodyType;
    private double vehiclePrice;
    private int milesOnVehicle;
    private double interestRate;
    private String locationOfVehicle;
    private String vehicleDescription;
    private String sellerName;
    private String sellerContactNumber;

}
