package com.example.parking.controllers;

import com.example.parking.domain.spot.RequestSpotDTO;
import com.example.parking.domain.spot.ResponseSpotDTO;
import com.example.parking.services.SpotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpotController {

    private final SpotService spotService;

    public SpotController(SpotService spotService) {
        this.spotService = spotService;
    }

    @PostMapping("spots")
    public ResponseEntity<ResponseSpotDTO> createSpot(@RequestBody RequestSpotDTO requestSpotDTO) {
        return this.spotService.createSpot(requestSpotDTO);
    }

    @GetMapping("spots")
    ResponseEntity<List<ResponseSpotDTO>> getAllSpots() {
        return this.spotService.getAllspots();
    }

}
