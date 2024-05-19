package com.almo.reservation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Commande {
    @Id
    @GeneratedValue
    private LocalDateTime DateCommande;
    private String listeCommande;
    private int prixTotalCommande;
    private String statutCommande;

}
