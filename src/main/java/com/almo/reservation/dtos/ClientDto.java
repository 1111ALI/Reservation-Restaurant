package com.almo.reservation.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClientDto {
    @Id
    @GeneratedValue
    private String nomClient;
    private String emailClient;
    private String telephoneClient;

}
