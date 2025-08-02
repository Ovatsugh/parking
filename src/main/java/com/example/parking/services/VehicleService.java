package com.example.parking.services;

import com.example.parking.domain.vehicle.RequestVehicleDTO;
import com.example.parking.domain.vehicle.ResponseVehicleDTO;
import com.example.parking.domain.vehicle.VehicleType;
import com.example.parking.repositories.VehicleTypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleTypeRepository vehicleTypeRepository;

    public VehicleService(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    public ResponseEntity<ResponseVehicleDTO> createVehicle(RequestVehicleDTO requestVehicleDTO) {

        VehicleType vehicle = new VehicleType(requestVehicleDTO);

        VehicleType saveVehicle = this.vehicleTypeRepository.save(vehicle);

        ResponseVehicleDTO  responseVehicleDTO = new ResponseVehicleDTO(saveVehicle);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseVehicleDTO);
    }

    public ResponseEntity<List<ResponseVehicleDTO>> getAllVehicles() {
        List<VehicleType> vehicleTypeList = this.vehicleTypeRepository.findAll();

        List<ResponseVehicleDTO> vehicleTypeListDTO = vehicleTypeList.stream().map(ResponseVehicleDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(vehicleTypeListDTO);
    }

}
