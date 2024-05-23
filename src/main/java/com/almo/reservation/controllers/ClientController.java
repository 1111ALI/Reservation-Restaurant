package com.almo.reservation.controllers;

import com.almo.reservation.entity.Client;
import com.almo.reservation.service.impl.ClientServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clients/")
@AllArgsConstructor
public class ClientController {
    private final ClientServiceImpl clientService;

    // Recuperer tous les clients de la Table client dans la BD
    @GetMapping("get-all")
    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }

//    @GetMapping("get-all-Dto")
//    public List<Client> getAllClientDto() {
//
//        return clientService.getAllClientDto();
//    }
    // Enregistrement d'un client
    @PostMapping("create")
    public Client ceateClient (@RequestBody Client client){

        return clientService.ceateClient(client);
    }
// Supprimer un client
    @DeleteMapping("{id}")
    public String delateClientById (@PathVariable("id") UUID clientId){
return clientService.delateClientById(clientId);
    }
    // Chercher un client par son Id
    @GetMapping("{id}")
    public Client getClientById (@PathVariable("id") UUID clientId){

        return clientService.getClientById(clientId);
    }
// Mettre à jour un client
    @PutMapping("{id}")
    public Client updateClient (@PathVariable("id") UUID clientId, @RequestBody Client client){
        return clientService.updateClient(clientId, client);
    }

}
