package com.almo.reservation.service;

import com.almo.reservation.entity.Reservation;
import com.almo.reservation.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public List<Reservation> getAllReservation() {
        List<Reservation> reservationList = reservationRepository.findAll();
        return reservationList;
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public String deleteReservationById(UUID reservationId) {
        Reservation reservationToDelete = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("la reservation n'existe pas dans la BD"));
        reservationRepository.deleteById(reservationId);
        return "la reservation avec ID : " + reservationId + " supprimé avec succès !";
    }

    public Reservation getReservationById(UUID reservationId) {
        Reservation reservationToGet = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("la reservation n'existe pas dans la BD"));
        return reservationToGet;
    }


    public Reservation updateReservation(UUID reservationId, Reservation reservation) {
        Reservation existingReservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("la reservation n'existe pas dans la BD"));
        existingReservation.setDateReservation(reservation.getDateReservation());
        existingReservation.setNomClientReserv(reservation.getNomClientReserv());
        existingReservation.setNumeroTableReservation(reservation.getNumeroTableReservation());
        existingReservation.setStatutReservation(reservation.getStatutReservation());
        return reservationRepository.save(existingReservation);
    }
}
