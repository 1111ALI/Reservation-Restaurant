package com.almo.reservation.service.impl;

import com.almo.reservation.dtos.ClientDto;
import com.almo.reservation.entity.Client;
import com.almo.reservation.repository.ClientRepository;
import com.almo.reservation.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;


    public List<Client> getAllClient() {
        List<Client> clientList = clientRepository.findAll();
        return clientList;
    }

    public Client ceateClient(Client client) {

        return clientRepository.save(client);
    }

    public String delateClientById(UUID clientId) {
        Client clientToBeDelate = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException(" Le client n'exite pas dans la BD"));
        clientRepository.deleteById(clientId);
        return "client avec ID : " + clientId + " supprimé avec succès !";
    }

    public Client getClientById(UUID clientId) {
        Client clientToGet = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Le client n'existe pas dans la BD"));
        return clientToGet;
    }

    public Client updateClient(UUID clientId, Client client) {
        Client existingClient = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException(" le Client n'existe pas dans la BD"));

        existingClient.setNomClient(client.getNomClient());
        existingClient.setEmailClient(client.getEmailClient());
        existingClient.setTelephoneClient(client.getTelephoneClient());

        return clientRepository.save(existingClient);
    }

//    public List<Client> getAllClientDto() {
//        List<Client> clientList = clientRepository.findAll();
//        List<Client> clientListDto = new ArrayList<>();
//
//        for (Client client : clientList) {
//            clientListDto.add(new ClientDto.(client.getNomClient(),
//                    client.getEmailClient(),
//                    client.getTelephoneClient()));
//        }
//                    return clientListDto;
//    }

}
