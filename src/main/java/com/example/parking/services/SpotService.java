package com.example.parking.services;

import com.example.parking.domain.spot.RequestSpotDTO;
import com.example.parking.domain.spot.ResponseSpotDTO;
import com.example.parking.domain.spot.Spot;
import com.example.parking.domain.vehicle.VehicleType;
import com.example.parking.repositories.SpotRepository;
import com.example.parking.repositories.VehicleTypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotService {

    private final SpotRepository spotRepository;
    private final VehicleTypeRepository vehicleTypeRepository;

    public SpotService(SpotRepository spotRepository, VehicleTypeRepository vehicleTypeRepository) {
        this.spotRepository = spotRepository;
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    public ResponseEntity<ResponseSpotDTO> createSpot(RequestSpotDTO requestSpotDTO) {

        VehicleType vehicleType = this.vehicleTypeRepository.findById(requestSpotDTO.getVehicle_type_id()).orElseThrow(() -> new RuntimeException("Vaga não encontrada"));
        Spot spot = new Spot(vehicleType);

        Spot savedSpot = this.spotRepository.save(spot);

        ResponseSpotDTO responseSpotDTO = new ResponseSpotDTO(savedSpot);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseSpotDTO);
    }

    public ResponseEntity<List<ResponseSpotDTO>> getAllspots() {
        List<Spot> spots = spotRepository.findAll();
        List<ResponseSpotDTO> responseSpotDTOS = spots.stream().map(ResponseSpotDTO::new).toList();

        return  ResponseEntity.status(HttpStatus.OK).body(responseSpotDTOS);
    }




}
