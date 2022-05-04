package com.hiberus.university.selenium.constantes;

public interface Consts {

    // -------------------------------------- \\
    // ---- DEFINICION DE LAS CONSTANTES ---- \\
    // -------------------------------------- \\
    String PATH_CONFIGURACION = "C:\\Users\\ArielM\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";

    String PAGINA_LOGIN = "https://www.saucedemo.com/";
    String PAGINA_INVENTARIO = "https://www.saucedemo.com/inventory.html";
    String USERNAME = "standard_user";
    String PASSWORD = "secret_sauce";

    /* ------------------------------- */
    /* ------- COLORES CONSOLA ------- */
    /* ------------------------------- */

    String COLOR_VERDE = "\u001B[32m\n";
    String COLOR_ROJO = "\u001B[31m\n";

    /* ------------------------------ */
    /* --- ELEMENTOS DE LA PÁGINA --- */
    /* ------------------------------ */

    String ID_INPUT_USERNAME = "user-name";
    String ID_INPUT_PASSWORD = "password";
    String ID_BOTON_LOGIN = "login-button";
    String XPATH_DIV_ERROR = "//h3[@data-test='error']";
    String CLASS_INVENTORY_PRODUCT = "inventory_item";
    String CLASS_NAME_INVENTORY_PRODUCT = "inventory_item_name";
    String XPATH_TITLE_BOLT_TSHIRT = "//div[text()='Sauce Labs Bolt T-Shirt']";
    String ID_BUTTON_ADD_BOLT_TSHIRT = "add-to-cart-sauce-labs-bolt-t-shirt";
    String ID_BUTTON_ADD_ONESIE = "add-to-cart-sauce-labs-onesie";
    String ID_BUTTON_REMOVE_ONESIE = "remove-sauce-labs-onesie";
    String CLASS_SHOPPING_CART_NUMBER = "shopping_cart_badge";
    String XPATH_BOTONES_REMOVE = "//button[contains(@id, 'remove')]";
    String XPATH_BOTONES_ADD = "//button[contains(@id, 'add')]";
    String CLASS_PRODUCT_PRICE = "inventory_item_price";
    String XPATH_OPTION_MENOR_MAYOR_PRECIO = "//option[@value='lohi']";
    String XPATH_OPTION_MAYOR_MENOR_PRECIO = "//option[@value='hilo']";


}
