package com.hiberus.university.selenium.login;

import com.hiberus.university.selenium.constantes.Constantes;
import com.hiberus.university.selenium.constantes.InicializacionDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.matcher.CollectionOneToOneMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginCorrecto {

    private static WebDriver driver;

    public static void main(String args[]) {

        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        driver = InicializacionDriver.init(driver, Constantes.PAGINA_LOGIN);

        // --------- EJECUCIÓN DEL DRIVER --------- \\
        WebElement inputUsername = driver.findElement(By.id(Constantes.ID_INPUT_USERNAME));
        WebElement inputPassword = driver.findElement(By.id(Constantes.ID_INPUT_PASSWORD));
        WebElement botonLogin = driver.findElement(By.id(Constantes.ID_BOTON_LOGIN));

        inputUsername.sendKeys(Constantes.USERNAME);
        inputPassword.sendKeys(Constantes.PASSWORD);
        botonLogin.click();

        boolean correcto = driver.getCurrentUrl().equals(Constantes.PAGINA_INVENTARIO);

        System.out.println("Login " + (correcto ? "correcto" : "incorrecto"));

        driver.close();
    }

}
