package com.example.parking.controllers;

import com.example.parking.domain.ticket.RequestFinishTicketDTO;
import com.example.parking.domain.ticket.RequestTicktDTO;
import com.example.parking.domain.ticket.ResponseTicketDTO;
import com.example.parking.services.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("tickets")
    public ResponseEntity<List<ResponseTicketDTO>> getAllTickets() {
        return this.ticketService.getAlltickt();
    }

    @PostMapping("tickets")
    ResponseEntity<ResponseTicketDTO> createTicket(RequestTicktDTO requestTicktDTO) {
        return this.ticketService.createTicket(requestTicktDTO);
    }

    @GetMapping("tickets/{plate}")
    ResponseEntity<ResponseTicketDTO> getTicketInfo(@PathVariable String plate) {
        return this.ticketService.getTickInfo(plate);
    }

    @PutMapping("tickets/{id}")
    ResponseEntity<ResponseTicketDTO> finishTicket(@PathVariable Integer id, @RequestBody RequestFinishTicketDTO ticket) {
        return this.ticketService.finishTickt(id, ticket);
    }



}
