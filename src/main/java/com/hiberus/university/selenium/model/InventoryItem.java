package com.hiberus.university.selenium.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


public class InventoryItem {
    // Como ente en la página de saucedemo compramos items, por eso creamos este objeto
    // Son private porque los obtendremos a través de getters y setters
    private String name;
    private String description;
    private String price; // Convertible a double


}

