package com.example.parking.domain.ticket;

import com.example.parking.domain.spot.Spot;
import com.example.parking.domain.vehicle.VehicleType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class ResponseTicketDTO {
    private Integer id;
    private String palate;
    private LocalDateTime entrance_time;
    private LocalDateTime exit_time;
    private Spot spot;
    private Float amount;
    private boolean payed;
    private VehicleType vehicleType;

    public ResponseTicketDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.palate = ticket.getPalate();
        this.entrance_time = ticket.getEntrance_time();
        this.exit_time = ticket.getExit_time();
        this.spot = ticket.getSpot();
        this.amount = ticket.getAmount();
        this.payed = ticket.isPayed();
        this.vehicleType = ticket.getVehicleType();
    }
}
