package com.almo.reservation.service;

import com.almo.reservation.entity.Table;
import com.almo.reservation.repository.TableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TableService {
    private final TableRepository tableRepository;

    public List<Table> getAllTable() {
        List<Table> tableList = tableRepository.findAll();
        return tableList;
    }

    public Table createTable(Table table) {
        return tableRepository.save(table);
    }

    public String deleteTable(UUID tableId) {
        Table tableToDelate = tableRepository.findById(tableId)
                .orElseThrow(() -> new RuntimeException("la table n'existe pas dans la BD"));
        tableRepository.deleteById(tableId);
        return "la table avec ID : " + tableId + " supprimé avec succès !";
    }

    public Table getTableById(UUID tableId) {
        Table tableToGet = tableRepository.findById(tableId)
                .orElseThrow(() -> new RuntimeException("la table n'existe pas dans la BD"));
        return tableToGet;
    }

    public Table updateTableById(UUID tableId, Table table) {
        Table existingTable = tableRepository.findById(tableId)
                .orElseThrow(() -> new RuntimeException("la table n'existe pas dans la BD"));
        existingTable.setNumeroTable(table.getNumeroTable());
        existingTable.setCapaciteTable(table.getCapaciteTable());
        return tableRepository.save(existingTable);
    }
}
