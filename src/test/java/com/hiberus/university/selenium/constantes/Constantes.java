package com.hiberus.university.selenium.constantes;

public interface Constantes {

    // -------------------------------------- \\
    // ---- DEFINICION DE LAS CONSTANTES ---- \\
    // -------------------------------------- \\
    public static final String PATH_CONFIGURACION = "C:\\Users\\ArielM\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";

    public static final String PAGINA_LOGIN = "https://www.saucedemo.com/";
    public static final String PAGINA_INVENTARIO = "https://www.saucedemo.com/inventory.html";
    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";

    /* ------------------------------ */
    /* --- ELEMENTOS DE LA PÁGINA --- */
    /* ------------------------------ */

    public static final String ID_INPUT_USERNAME = "user-name";
    public static final String ID_INPUT_PASSWORD = "password";
    public static final String ID_BOTON_LOGIN = "login-button";
    public static final String XPATH_DIV_ERROR = "//h3[@data-test='error']";


}
