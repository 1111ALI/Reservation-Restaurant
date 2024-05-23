package com.almo.reservation.service;

import com.almo.reservation.entity.Restaurant;
import com.almo.reservation.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RestaurantService {
    public final RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurant() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        return restaurantList;
    }

    public Restaurant createRestaurant(Restaurant restaurant) {

        return restaurantRepository.save(restaurant);
    }

    public String deleteRestaurantById(UUID restaurantId) {
        Restaurant restaurantToBeDelete = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("le restaurant n'existe pas dans la BD"));
        restaurantRepository.deleteById(restaurantId);
        return "le restaurant avec ID : " + restaurantId + " supprimé avec succès !";
    }

    public Restaurant getRestaurantById(UUID restaurantId) {
        Restaurant restaurantToGet = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("le restaurant n'existe pas dans la BD"));
        return restaurantToGet;
    }


    public Restaurant updateRestaurantById(UUID restaurantId, Restaurant restaurant) {
        Restaurant existingRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("le restaurant n'existe pas dans la BD"));

        existingRestaurant.setAdresseRestaurant(restaurant.getAdresseRestaurant());
        existingRestaurant.setTelephoneRestaurant(restaurant.getTelephoneRestaurant());
        existingRestaurant.setListeDesTables(restaurant.getListeDesTables());
        return restaurantRepository.save(existingRestaurant);
    }
}

