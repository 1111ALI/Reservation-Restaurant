package com.almo.reservation.controllers;

import com.almo.reservation.entity.Menu;
import com.almo.reservation.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/menus/")
@AllArgsConstructor
public class MenuController {
    private final MenuService menuService;

    // Recuperer tous les menus de la Table menu dans la BD
    @GetMapping("get-all")
    public List<Menu> getAllMenu() {
        return menuService.getAllMenu();
    }

    // Enregistrement d'un menu
    @PostMapping("create")
    public Menu createMenu(@RequestBody Menu menu) {
        return menuService.createMenu(menu);
    }

    // Supprimer un menu
    @DeleteMapping("{id}")
    public String deleteMenuById(@PathVariable("id") UUID menuId) {
        return menuService.deleteMenuById(menuId);
    }

    // Chercher un menu par son Id
    @GetMapping("{id}")
    public Menu getMenuById(@PathVariable("id") UUID menuId) {
        return menuService.getMenuById(menuId);
    }

    // Mettre à jour un menu
    @PutMapping("{id}")
    public Menu updateMenu(@PathVariable("id") UUID menuId, @RequestBody Menu menu) {
        return menuService.updateMenu(menuId, menu);
    }
}
