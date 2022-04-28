package com.hiberus.university.selenium.constantes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class InicializacionDriver {

    public static WebDriver init(WebDriver driver, String url) {

        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        String userProfile = Constantes.PATH_CONFIGURACION;

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get(url);

        return driver;
    }
}
