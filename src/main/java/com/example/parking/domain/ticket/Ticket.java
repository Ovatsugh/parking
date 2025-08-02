package com.example.parking.domain.ticket;

import com.example.parking.domain.spot.Spot;
import com.example.parking.domain.vehicle.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "plate")
    private String palate;

    @Column(name = "entrance_time")
    private LocalDateTime entrance_time;

    @Column(name = "exit_time")
    private LocalDateTime exit_time;

    @ManyToOne
    @JoinColumn(name = "id_spot")
    private Spot spot;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "payed")
    private boolean payed;

    @ManyToOne
    @JoinColumn(name = "id_vehicle_type")
    private VehicleType vehicleType;


    public Ticket(RequestTicktDTO ticktDTO,Spot spot, VehicleType vehicleType) {
        this.palate = ticktDTO.getPalate();
        this.entrance_time = LocalDateTime.now();
        this.spot = spot;
        this.vehicleType = vehicleType;
    }


}
