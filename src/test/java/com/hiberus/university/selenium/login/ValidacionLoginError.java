package com.hiberus.university.selenium.login;

import com.hiberus.university.selenium.constantes.Constantes;
import com.hiberus.university.selenium.constantes.InicializacionDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ValidacionLoginError {
    private static WebDriver driver;

    public static void main(String args[]) {
        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        driver = InicializacionDriver.init(driver, Constantes.PAGINA_LOGIN);

        // --------- EJECUCIÓN DEL DRIVER --------- \\
        WebElement inputUsername = driver.findElement(By.id(Constantes.ID_INPUT_USERNAME));
        WebElement inputPassword = driver.findElement(By.id(Constantes.ID_INPUT_PASSWORD));
        WebElement botonLogin = driver.findElement(By.id(Constantes.ID_BOTON_LOGIN));

        inputUsername.sendKeys("standard_use"); // Introducimos un usuario erroneo
        inputPassword.sendKeys(Constantes.PASSWORD);
        botonLogin.click();

        // Si se inicia sesion no se puede completar la prueba
        if (driver.getCurrentUrl() == Constantes.PAGINA_INVENTARIO) {
            System.out.println("El login es correcto por favor escoja un usuario erroneo para el buen funcionamiento de la prueba\n\nPRUEBA FALLIDA");
            driver.close();
            return;
        }

        WebElement mensajeError;
        try {
           mensajeError  = driver.findElement(By.xpath(Constantes.XPATH_DIV_ERROR));
        } catch (Exception e) {
            System.out.println("NO se muestra el mensaje de error");
            driver.close();
            return;
        }

        boolean seVeMensajeError = mensajeError.isDisplayed();

        System.out.println((seVeMensajeError ? "S" : "NO s") + "e muestra el mensaje de error");

        driver.close();
    }
}
