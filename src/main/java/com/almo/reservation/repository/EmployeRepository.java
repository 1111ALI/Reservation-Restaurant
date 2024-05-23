package com.almo.reservation.repository;

import com.almo.reservation.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeRepository extends JpaRepository<Employe, UUID> {

}
