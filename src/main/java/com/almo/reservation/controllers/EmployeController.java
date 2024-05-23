package com.almo.reservation.controllers;

import com.almo.reservation.entity.Employe;
import com.almo.reservation.service.EmployeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employes/")
@AllArgsConstructor
public class EmployeController {
    private final EmployeService employeService;

    // Recuperer tous les employés de la Table employe dans la BD
@GetMapping("get-all")
    public List<Employe> getAllEmploye (){

    return employeService.getAllEmploye();
    }
    // Enregistrement d'un employe
    @PostMapping("create")
    public Employe createEmploye (@RequestBody Employe employe){
        return employeService.createEmploye(employe);
    }
    // Supprimer un employe
    @DeleteMapping("{id}")
    public String deleteEmployeById(@PathVariable("id")UUID employeId){
    return employeService.deleteEmployeById(employeId);
    }
    // Chercher un employe par son Id
    @GetMapping("{id}")
    public Employe getEmployeById (@PathVariable("id") UUID employeId){
    return employeService.getEmployeById(employeId);
    }
    // Mettre à jour un employe
    @PutMapping("{id}")
    public Employe UpdateEmploye ( @PathVariable("id") UUID employeId, @RequestBody Employe employe){
    return employeService.UpdateEmploye(employeId, employe);

    }
}
