package com.example.parking.domain.ticket;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestFinishTicketDTO {
    private LocalDateTime exit_time;
    private Float amount;
    private Integer spot_id;

}