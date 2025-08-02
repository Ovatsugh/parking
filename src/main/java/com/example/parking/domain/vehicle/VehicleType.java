package com.example.parking.domain.vehicle;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicle")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "vehicle")
    private String vehicle;

    public VehicleType(RequestVehicleDTO requestVehicleDTO) {
        this.vehicle = requestVehicleDTO.getVehicle();
    }
}
