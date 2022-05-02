package com.hiberus.university.selenium.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Realizarlogin {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Paso 1:
        // Abra el sitio web “https://www.saucedemo.com/” ->es
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);

        // Paso 2:
        // Escribir el username standard_user ->
        WebElement userBox = driver.findElement(By.id("user-name"));
        userBox.sendKeys("standard_user");
        Thread.sleep(2000);

        // Paso 3:
        // Escribir el password secret_sauce ->
        WebElement passBox = driver.findElement(By.id("password"));
        passBox.sendKeys("secret_sauce");
        Thread.sleep(2000);

        // Paso 4:
        // Pulsar en el botón del login ->
        WebElement clickButton = driver.findElement(By.id("login-button"));
        clickButton.click();
        Thread.sleep(2000);

        // Paso 5:
        // Validar que hemos accedido correctamente a la página ->
        String url = driver.getCurrentUrl();

        if(url.equals("https://www.saucedemo.com/inventory.html")){
            System.out.println("Página Correcta");
        }else{
            System.out.println("Página Incorrecta");
        }

        Thread.sleep(2000);

        driver.quit();

    }
}

