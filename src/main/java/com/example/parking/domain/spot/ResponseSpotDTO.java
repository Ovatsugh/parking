package com.example.parking.domain.spot;

import com.example.parking.domain.vehicle.VehicleType;
import lombok.Data;

@Data
public class ResponseSpotDTO {
    private Integer id;
    private boolean occupied;
    private VehicleType vehicleType;

    public ResponseSpotDTO(Spot spot) {
        this.id = spot.getId();
        this.occupied = spot.isOccuppied();
        this.vehicleType = spot.getVehicle();
    }
}
