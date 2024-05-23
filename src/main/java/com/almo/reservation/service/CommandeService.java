package com.almo.reservation.service;

import com.almo.reservation.entity.Commande;
import com.almo.reservation.repository.CommandeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class CommandeService {
    private final CommandeRepository commandeRepository;

    public List<Commande> getAllCommande() {
        List<Commande> commandeList = commandeRepository.findAll();
        return commandeList;
    }

    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public String deleteCommandeById(UUID commandeId) {
        Commande commandeToBeDelete = commandeRepository.findById(commandeId)
                .orElseThrow(() -> new RuntimeException(" La commande n'existe pas dans la BD"));
        commandeRepository.deleteById(commandeId);
        return " la commande avec ID : " + commandeId + " supprimé avec succès !";
    }

    public Commande getCommandeById(UUID commandeId) {
        Commande commandeToGet = commandeRepository.findById(commandeId)
                .orElseThrow(() -> new RuntimeException("cette commande n'existe pas"));
        return commandeToGet;
    }

    public Commande updateCommande(UUID commandeId, Commande commande) {
        Commande existingCommande = commandeRepository.findById(commandeId)
                .orElseThrow(() -> new RuntimeException("La commande n'existe pas dans la BD"));

        existingCommande.setDateCommande(commande.getDateCommande());
        existingCommande.setListeCommande(commande.getListeCommande());
        existingCommande.setPrixTotalCommande(commande.getPrixTotalCommande());
        existingCommande.setStatutCommande(commande.getStatutCommande());

        return commandeRepository.save(existingCommande);
    }
}
