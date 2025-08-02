package com.example.parking.domain.vehicle;

import lombok.Data;

@Data
public class ResponseVehicleDTO {
    private Integer id;
    private String vehicle;

    public ResponseVehicleDTO(VehicleType vehicleType) {
        this.id = vehicleType.getId();
        this.vehicle = vehicleType.getVehicle();
    }

}
