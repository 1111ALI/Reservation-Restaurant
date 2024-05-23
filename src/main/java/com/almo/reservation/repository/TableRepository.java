package com.almo.reservation.repository;

import com.almo.reservation.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TableRepository extends JpaRepository<Table, UUID> {
}
