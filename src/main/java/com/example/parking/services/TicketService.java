package com.example.parking.services;


import com.example.parking.domain.spot.Spot;
import com.example.parking.domain.ticket.RequestFinishTicketDTO;
import com.example.parking.domain.ticket.RequestTicktDTO;
import com.example.parking.domain.ticket.ResponseTicketDTO;
import com.example.parking.domain.ticket.Ticket;
import com.example.parking.domain.vehicle.VehicleType;
import com.example.parking.repositories.SpotRepository;
import com.example.parking.repositories.TicketRepository;
import com.example.parking.repositories.VehicleTypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class TicketService {

    private final SpotRepository spotRepository;
    private final VehicleTypeRepository vehicleTypeRepository;
    private final TicketRepository ticketRepository;

    public TicketService(SpotRepository spotRepository, VehicleTypeRepository vehicleTypeRepository, TicketRepository ticketRepository) {
        this.spotRepository = spotRepository;
        this.vehicleTypeRepository = vehicleTypeRepository;
        this.ticketRepository = ticketRepository;
    }

    public ResponseEntity<ResponseTicketDTO>  createTicket(RequestTicktDTO requestTicktDTO) {

        Spot spot = this.spotRepository.findById(requestTicktDTO.getSpot_id()).orElseThrow(() -> new RuntimeException("Vaga não encontada"));
        VehicleType vehicleType = this.vehicleTypeRepository.findById(requestTicktDTO.getVehicle_type_id()).orElseThrow(() -> new RuntimeException("Tipo não encontado"));


//        if(spot.isOccuppied()) {
//           throw new  RuntimeException("Vaga não disponível");
//        }
//
//        if(!Objects.equals(spot.getVehicle().getVehicle(), vehicleType.getVehicle())) {
//            throw new RuntimeException("Essa vaga não condiz");
//        }

        Ticket tick = new Ticket(requestTicktDTO, spot, vehicleType);

        Ticket savedTickt = this.ticketRepository.save(tick);
        Spot test = savedTickt.getSpot();
        System.out.println(test);
        spot.setOccuppied(true);
        spotRepository.save(spot);

        System.out.println(savedTickt);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseTicketDTO(savedTickt));

    }

    public ResponseEntity<List<ResponseTicketDTO>> getAlltickt() {
        List<Ticket> tickts = ticketRepository.findAll();
        List<ResponseTicketDTO> responseTicketDTOS = tickts.stream().map(ResponseTicketDTO::new).toList();

        return ResponseEntity.ok(responseTicketDTOS);
    }

    public ResponseEntity<ResponseTicketDTO> getTickInfo(String plate) {
        Ticket ticket = this.ticketRepository.findByPalateAndPayedFalse(plate).orElseThrow(() -> new RuntimeException("Ticket nao encontrado"));

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime entrance_time = ticket.getEntrance_time();

        Duration duration = Duration.between(entrance_time, now);

        long seconds = duration.toSeconds();

        float pricePerMinute = 0.75f;
        float amount = seconds * pricePerMinute;


        ticket.setAmount(amount);
        ticket.setExit_time(now);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseTicketDTO(ticket));
    }

    public ResponseEntity<ResponseTicketDTO> finishTickt(Integer id, RequestFinishTicketDTO ticketDTO) {
        Ticket ticket = this.ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket nao encontrado"));

        ticket.setAmount(ticketDTO.getAmount());
        ticket.setExit_time(ticketDTO.getExit_time());
        ticket.setPayed(true);

        Spot spot = this.spotRepository.findById(ticketDTO.getSpot_id()).orElseThrow(() -> new RuntimeException("Vaga não encontada"));
        spot.setOccuppied(true);
        spotRepository.save(spot);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseTicketDTO(ticket));
    }


}
