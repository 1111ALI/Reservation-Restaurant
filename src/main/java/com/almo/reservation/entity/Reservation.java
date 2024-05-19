package com.almo.reservation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Reservation {
@Id
@GeneratedValue
    private UUID reservationId;
    private LocalDateTime dateReservation;
    private String nomClientReserv;
    private String numeroTableReservation;
    private String statutReservation;
}
