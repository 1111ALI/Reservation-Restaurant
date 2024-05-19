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

public class Restaurant {
    @Id
    @GeneratedValue
private UUID restaurantId;
private String nomRestaurant;
private String adresseRestaurant;
private String telephoneRestaurant;
private String listeDesTables;
}
