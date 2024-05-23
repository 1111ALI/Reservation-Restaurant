package com.almo.reservation.controllers;

import com.almo.reservation.entity.Restaurant;
import com.almo.reservation.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/restaurants/")
@AllArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    // Recuperer tous les restaurantss de la Table restaurant dans la BD
    @GetMapping("get-all")
    public List<Restaurant> getAllRestaurant() {
        return restaurantService.getAllRestaurant();
    }

    // Enregistrement d'un restaurant
    @PostMapping("create")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }

    // Supprimer un restaurant
    @DeleteMapping("{id}")
    public String deleteRestaurantById(@PathVariable("id") UUID restaurantId) {
        return restaurantService.deleteRestaurantById(restaurantId);
    }

    // Chercher un restaurant par son Id
    @GetMapping("{id}")
    public Restaurant getRestaurantById(@PathVariable("id") UUID restaurantId) {
        return restaurantService.getRestaurantById(restaurantId);
    }
    // Mettre à jour un employe
    @PutMapping("{id}")
    public Restaurant updateRestaurantById (@PathVariable("id") UUID restaurantId, @RequestBody Restaurant restaurant){
        return restaurantService.updateRestaurantById(restaurantId, restaurant);

    }

}
