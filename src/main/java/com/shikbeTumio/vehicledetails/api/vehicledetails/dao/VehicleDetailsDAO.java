package com.shikbeTumio.vehicledetails.api.vehicledetails.dao;

import com.shikbeTumio.vehicledetails.api.vehicledetails.entity.VehicleDetails;
import lombok.Builder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDetailsDAO extends JpaRepository<VehicleDetails, Integer> {
}
