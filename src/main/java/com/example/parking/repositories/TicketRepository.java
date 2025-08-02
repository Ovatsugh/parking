package com.example.parking.repositories;

import com.example.parking.domain.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Optional<Ticket> findByPalateAndPayedFalse(String plate);
}
