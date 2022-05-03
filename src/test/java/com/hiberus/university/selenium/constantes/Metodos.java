package com.hiberus.university.selenium.constantes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Metodos {

    public static WebDriver init(WebDriver driver, String url) {

        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        String userProfile = Consts.PATH_CONFIGURACION;

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);

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

    public static void quitarElementosCarro(WebDriver driver) {
        try {
            driver.findElements(By.xpath("//button[contains(@id, 'remove')]"))
                    .forEach(element -> element.click());
        } catch (Exception e){}
    }
}
