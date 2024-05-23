package com.almo.reservation.controllers;

import com.almo.reservation.entity.Commande;
import com.almo.reservation.service.CommandeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/commandes/")
@AllArgsConstructor
public class CommandeController {
    private final CommandeService commandeService;

    // Recuperer toutes les commandes de la Table commande dans la BD
@GetMapping("get-all")
    public List<Commande> getAllCommande(){
        return commandeService.getAllCommande();
    }
// Enregistrement d'une commande
@PostMapping("create")
    public Commande createCommande (@RequestBody Commande commande){
    return commandeService.createCommande(commande);
    }
    // Supprimer une commande
    @DeleteMapping("{id}")
    public String deleteCommandeById (@PathVariable ("id") UUID commandeId){
    return  commandeService.deleteCommandeById(commandeId);
    }
    // Chercher une commande par son Id
    @GetMapping("{id}")
    public Commande getCommandeById (@PathVariable("id") UUID commandeId){
    return commandeService.getCommandeById(commandeId);
    }
    // Mettre à jour un client
    @PutMapping("{id}")
    public Commande updateCommande (@PathVariable("id") UUID commandeId, @RequestBody Commande commande){
    return commandeService.updateCommande(commandeId, commande);
    }

}
