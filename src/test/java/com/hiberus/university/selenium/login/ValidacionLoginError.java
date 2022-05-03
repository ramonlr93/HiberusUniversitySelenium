package com.hiberus.university.selenium.login;

import com.hiberus.university.selenium.constantes.Consts;
import com.hiberus.university.selenium.constantes.Metodos;
import org.openqa.selenium.*;

public class ValidacionLoginError {
    private static WebDriver driver;

    public static void main(String args[]) {
        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        driver = Metodos.init(driver, Consts.PAGINA_LOGIN);

        // --------- EJECUCIÓN DEL DRIVER --------- \\
        Metodos.login(driver, "standard_use", Consts.PASSWORD);

        // Si se inicia sesion no se puede completar la prueba
        if (driver.getCurrentUrl() == Consts.PAGINA_INVENTARIO) {
            System.out.println("El login es correcto por favor escoja un usuario erroneo para el buen funcionamiento de la prueba\n\nPRUEBA FALLIDA");
            driver.close();
            return;
        }

        WebElement mensajeError;
        try {
           mensajeError  = driver.findElement(By.xpath(Consts.XPATH_DIV_ERROR));
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
