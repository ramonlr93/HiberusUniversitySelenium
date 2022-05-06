package com.hiberus.university.selenium.Inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class VisibilidadEliminarCarrito {
    public static WebDriver driver;

    public static void main(String[] args) {

        //Paso0
        String userProfile = "C:\\Users\\scasado\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Paso1 Ir a la pagina
        driver.get("https://www.saucedemo.com/");
        //Paso2 Escribir el username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Paso3 Escribir el password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Paso 4. Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();
        //Paso5 Agregamos producto al carrito
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        //Paso 6 Visibilidad botón Eliminar carrito
       boolean status = driver.findElement(By.id("remove-sauce-labs-onesie")).isDisplayed();
       //Paso 7
        driver.findElement(By.id("remove-sauce-labs-onesie")).click();
        driver.quit();
    }
}
