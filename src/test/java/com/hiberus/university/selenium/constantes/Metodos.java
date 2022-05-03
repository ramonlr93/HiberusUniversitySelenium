package com.hiberus.university.selenium.constantes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Metodos {

    public static WebDriver init(String url) {

        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        String userProfile = Consts.PATH_CONFIGURACION;

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get(url);

        return driver;
    }

    public static void login(WebDriver driver, String username, String password) {
        WebElement inputUsername = driver.findElement(By.id(Consts.ID_INPUT_USERNAME));
        WebElement inputPassword = driver.findElement(By.id(Consts.ID_INPUT_PASSWORD));
        WebElement botonLogin = driver.findElement(By.id(Consts.ID_BOTON_LOGIN));

        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        botonLogin.click();
    }

    public static void login(WebDriver driver) {
        login(driver, Consts.USERNAME, Consts.PASSWORD);
    }

    // METODO PARA QUITAR LOS ELEMENTOS DEL CARRO EN CASO DE QUE HAYA,
    //  CON SI SE HA AÑADIDO AL CARRO EN UNA SESIÓN ANTERIOR SE QUEDA PARA LA SIGUIENTE,
    //  ENTONCES CUANDO PROBAMOS QUEREMOS QUE NINGÚN ELEMENTO ESTE SELECCIONADO PARA EL CORRECTO FUNCIONAMIENTO DE LAS PRUEBAS
    public static void quitarElementosCarro(WebDriver driver) {
        try {
            driver.findElements(By.xpath(Consts.XPATH_BOTONES_REMOVE))
                    .forEach(element -> element.click());
        } catch (Exception e){}
    }
}
