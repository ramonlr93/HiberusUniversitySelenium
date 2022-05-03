package com.hiberus.university.selenium;

import static org.junit.Assert.assertTrue;

import com.hiberus.university.selenium.constantes.Consts;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private static WebDriver driver;
    @Test
    public static void main(String args[])
    {
        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        String userProfile = Consts.PATH_CONFIGURACION;

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // --------- EJECUCIÓN DEL DRIVER --------- \\
        driver.get(Consts.PAGINA_LOGIN);


/*
        // Prueba Login Correcto
        Login login = new Login(driver, Constantes.USERNAME, Constantes.PASSWORD);
        boolean correcto = login.correcto();

        System.out.println("Login " + (correcto ? "correcto" : "incorrecto"));
/*
        // Prueba sale texto de error
        driver.navigate().to(Constantes.PAGINA_LOGIN);
        boolean seVeTextoError = login.incorrecto();

        System.out.println(seVeTextoError ? "Se muestra mensaje de error" : "No se muestra mensaje de error");

        // --------- FINALIZACIÓN DEL DRIVER --------- \\*/
        driver.close();
    }
}
