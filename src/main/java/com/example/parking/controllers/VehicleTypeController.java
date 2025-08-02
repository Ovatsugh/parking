package com.example.parking.controllers;

import com.example.parking.domain.vehicle.RequestVehicleDTO;
import com.example.parking.domain.vehicle.ResponseVehicleDTO;
import com.example.parking.services.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleTypeController {

    private final VehicleService vehicleService;

    public VehicleTypeController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("vehicles")
    public ResponseEntity<ResponseVehicleDTO> createVehicle(@RequestBody RequestVehicleDTO requestVehicleDTO) {
     return this.vehicleService.createVehicle(requestVehicleDTO);
    }

    @GetMapping("vehicles")
    public ResponseEntity<List<ResponseVehicleDTO>> getAllVehicles() {
        return this.vehicleService.getAllVehicles();
    }
}
