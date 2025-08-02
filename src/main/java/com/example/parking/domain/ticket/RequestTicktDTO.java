package com.example.parking.domain.ticket;

import com.example.parking.domain.spot.Spot;
import com.example.parking.domain.vehicle.VehicleType;
import lombok.Data;

@Data
public class RequestTicktDTO {
    private String palate;
    private Integer vehicle_type_id;
    private Integer spot_id;
}
