package com.hiberus.university.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Constantes {

    public static WebDriver initDriver(String url) {

        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        String userProfile = PATH_CONFIGURACION;

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(250, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        driver.get(url);

        return driver;
    }
    public static WebDriverWait initWait(WebDriver driver) {
        return new WebDriverWait(driver, 10, 500);
    }

    public static void login(WebDriver driver, String username, String password) {
        WebElement inputUsername = driver.findElement(By.id(ID_INPUT_USERNAME));
        WebElement inputPassword = driver.findElement(By.id(ID_INPUT_PASSWORD));
        WebElement botonLogin = driver.findElement(By.id(ID_BOTON_LOGIN));

        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        botonLogin.click();
    }

    public static void login(WebDriver driver) {
        login(driver, USERNAME, PASSWORD);
    }

    // METODO PARA QUITAR LOS ELEMENTOS DEL CARRO EN CASO DE QUE HAYA,
    //  CON SI SE HA AÑADIDO AL CARRO EN UNA SESIÓN ANTERIOR SE QUEDA PARA LA SIGUIENTE,
    //  ENTONCES CUANDO PROBAMOS QUEREMOS QUE NINGÚN ELEMENTO ESTE SELECCIONADO PARA EL CORRECTO FUNCIONAMIENTO DE LAS PRUEBAS
    public static void quitarElementosCarro(WebDriver driver) {
        try {
            driver.findElements(By.xpath(XPATH_BOTONES_REMOVE))
                    .forEach(element -> element.click());
        } catch (Exception e){}
    }

    // -------------------------------------- \\
    // ---- DEFINICION DE LAS CONSTANTES ---- \\
    // -------------------------------------- \\
    public static final String PATH_CONFIGURACION = "C:\\Users\\ArielM\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";

    public static final String PAGINA_LOGIN = "https://www.saucedemo.com/";
    public static final String PAGINA_INVENTARIO = "https://www.saucedemo.com/inventory.html";
    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";

    /* ------------------------------- */
    /* ------- COLORES CONSOLA ------- */
    /* ------------------------------- */

    public static final String COLOR_VERDE = "\u001B[32m\n";
    public static final String COLOR_ROJO = "\u001B[31m\n";

    /* ------------------------------ */
    /* --- ELEMENTOS DE LA PÁGINA --- */
    /* ------------------------------ */

    public static final String ID_INPUT_USERNAME = "user-name";
    public static final String ID_INPUT_PASSWORD = "password";
    public static final String ID_BOTON_LOGIN = "login-button";
    public static final String XPATH_DIV_ERROR = "//h3[@data-test='error']";
    public static final String CLASS_INVENTORY_PRODUCT = "inventory_item";
    public static final String CLASS_NAME_INVENTORY_PRODUCT = "inventory_item_name";
    public static final String XPATH_TITLE_BOLT_TSHIRT = "//div[text()='Sauce Labs Bolt T-Shirt']";
    public static final String ID_BUTTON_ADD_BOLT_TSHIRT = "add-to-cart-sauce-labs-bolt-t-shirt";
    public static final String ID_BUTTON_ADD_ONESIE = "add-to-cart-sauce-labs-onesie";
    public static final String ID_BUTTON_REMOVE_ONESIE = "remove-sauce-labs-onesie";
    public static final String CLASS_SHOPPING_CART_NUMBER = "shopping_cart_badge";
    public static final String XPATH_BOTONES_REMOVE = "//button[contains(@id, 'remove')]";
    public static final String XPATH_BOTONES_ADD = "//button[contains(@id, 'add')]";
    public static final String CLASS_PRODUCT_PRICE = "inventory_item_price";
    public static final String XPATH_OPTION_MENOR_MAYOR_PRECIO = "//option[@value='lohi']";
    public static final String XPATH_OPTION_MAYOR_MENOR_PRECIO = "//option[@value='hilo']";
    public static final String ID_BOTON_CHECKOUT = "checkout";
    public static final String ID_INPUT_FIRST_NAME = "first-name";
    public static final String ID_INPUT_LAST_NAME = "last-name";
    public static final String ID_INPUT_POSTAL_CODE = "postal-code";
    public static final String ID_BOTON_CONTINUE = "continue";
    public static final String CLASS_DIV_TOTAL_PRICE = "summary_subtotal_label";
    public static final String ID_BOTON_FINISH = "finish";
    public static final String PAGINA_COMPRA_REALIZADA = "https://www.saucedemo.com/checkout-complete.html";

    public static final String ID_BOTON_LOG_OUT = "logout_sidebar_link";
    public static final String ID_BOTON_SACAR_MENU_LATERAL = "react-burger-menu-btn";
}
