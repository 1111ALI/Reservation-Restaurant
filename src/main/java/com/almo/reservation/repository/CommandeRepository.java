package com.almo.reservation.repository;

import com.almo.reservation.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommandeRepository extends JpaRepository<Commande, UUID> {

}
