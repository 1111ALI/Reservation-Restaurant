package com.almo.reservation.service;

import com.almo.reservation.entity.Employe;
import com.almo.reservation.repository.EmployeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeService {
    public final EmployeRepository employeRepository;

    public List<Employe> getAllEmploye() {
        List<Employe> employeList = employeRepository.findAll();
        return employeList;
    }

    public Employe createEmploye(Employe employe) {

        return employeRepository.save(employe);
    }

    public String deleteEmployeById(UUID employeId) {
        Employe employeToDelate = employeRepository.findById(employeId)
                .orElseThrow(() -> new RuntimeException(" l'employé n'existe pas dans la BD"));
        employeRepository.deleteById(employeId);
        return "employé avec ID : " + employeId + " supprimé avec succès !";
    }

    public Employe getEmployeById(UUID employeId) {
        Employe employeToGet = employeRepository.findById(employeId)
                .orElseThrow(() -> new RuntimeException(" l'employé n'existe pas dans la BD "));
        return employeToGet;
    }

    public Employe UpdateEmploye(UUID employeId, Employe employe) {
        Employe existingEmploye = employeRepository.findById(employeId)
                .orElseThrow(() -> new RuntimeException("l'employé n'existe pas dans la BD"));

        existingEmploye.setNomEmploye(employe.getNomEmploye());
        existingEmploye.setEmailEmploye(employe.getEmailEmploye());
        existingEmploye.setTelphoneEmploye(employe.getTelphoneEmploye());
        return employeRepository.save(existingEmploye);
    }

}
