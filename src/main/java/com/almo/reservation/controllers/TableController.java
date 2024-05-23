package com.almo.reservation.controllers;

import com.almo.reservation.entity.Table;
import com.almo.reservation.service.TableService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tables/")
@AllArgsConstructor
public class TableController {
    private final TableService tableService;

    // Recuperer tous les tables de la Table table dans la BD
    @GetMapping("get-all")
    public List<Table> getAllTable() {
        return tableService.getAllTable();
    }

    // Enregistrement d'une table
    @PostMapping("create")
    public Table createTable(@RequestBody Table table) {
        return tableService.createTable(table);
    }

    // Supprimer une table
    @DeleteMapping("{id}")
    public String deleteTable(@PathVariable("id") UUID tableId) {
        return tableService.deleteTable(tableId);
    }

    // Chercher une table par son Id
    @GetMapping("{id}")
    public Table getTableById(@PathVariable("id") UUID tableId) {
        return tableService.getTableById(tableId);
    }

    // Mettre à jour une table
    @PutMapping("{id}")
    public Table updateTableById(@PathVariable("id") UUID tableId, @RequestBody Table table) {
        return tableService.updateTableById(tableId, table);

    }
}
