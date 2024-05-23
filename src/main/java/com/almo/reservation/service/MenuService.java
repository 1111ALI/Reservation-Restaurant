package com.almo.reservation.service;

import com.almo.reservation.entity.Menu;
import com.almo.reservation.repository.MenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MenuService {
    public final MenuRepository menuRepository;

    public List<Menu> getAllMenu() {
        List<Menu> menuList = menuRepository.findAll();
        return menuList;
    }

    public Menu createMenu(Menu menu) {

        return menuRepository.save(menu);
    }

    public String deleteMenuById(UUID menuId) {
        Menu menuToBeDelete = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("le menu n'existe pas dans la BD"));
        menuRepository.deleteById(menuId);
        return "menu avec ID : " + menuId + " supprimé avec succès !";
    }

    public Menu getMenuById(UUID menuId) {
        Menu menuToGet = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("le menu n'existe pas dans la BD"));
        return menuToGet;
    }

    public Menu updateMenu(UUID menuId, Menu menu) {
        Menu existingMenu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("le menu n'existe pas dans la BD"));

        existingMenu.setNomMenu(menu.getNomMenu());
        existingMenu.setDescription(menu.getDescription());
        existingMenu.setPrixMenu(menu.getPrixMenu());
        existingMenu.setRestaurant(menu.getRestaurant());
        return menuRepository.save(existingMenu);
    }
}
