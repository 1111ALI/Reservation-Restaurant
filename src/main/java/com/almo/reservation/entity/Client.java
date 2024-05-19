package com.almo.reservation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
@Id
@GeneratedValue
    private UUID clientId;
    private String nomClient;
    private String emailClient;
    private String telephoneClient;
}
