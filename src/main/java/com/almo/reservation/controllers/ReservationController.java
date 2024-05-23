package com.almo.reservation.controllers;

import com.almo.reservation.entity.Reservation;
import com.almo.reservation.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/reservations/")
@AllArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    // Recuperer toutes les reservations de la Table reservation dans la BD
    @GetMapping("get-all")
    public List<Reservation> getAllReservation() {
        return reservationService.getAllReservation();
    }

    // Enregistrement d'une reservation
    @PostMapping("create")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    // Supprimer une reservation
    @DeleteMapping("{id}")
    public String deleteReservationById(@PathVariable("id") UUID reservationId) {
        return reservationService.deleteReservationById(reservationId);
    }

    // Chercher une reservation par son Id
    @GetMapping("{id}")
    public Reservation getReservationById(@PathVariable("id") UUID reservationId) {
        return reservationService.getReservationById(reservationId);
    }

    // Mettre à jour une reservation
    public Reservation updateReservation(@PathVariable("id") UUID reservationId, @RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservationId, reservation);

    }
}
