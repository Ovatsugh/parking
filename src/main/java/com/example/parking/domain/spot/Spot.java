package com.example.parking.domain.spot;

import com.example.parking.domain.vehicle.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "spot")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "occupied")
    private boolean occuppied;

    @ManyToOne
    @JoinColumn(name = "id_vehicle_type")
    private VehicleType vehicle;

    public Spot(VehicleType vehicle) {
        this.vehicle = vehicle;
    }
}
