package com.hiberus.university.selenium.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class VisibilidadBoton {
    //Visibilidad del botón Eliminar producto del carrito:
    public static WebDriver driver;
    public static void main(String[] args) {
        //Validar el número de resultados:

        //Crear el WebDriver
        String userProfile = "C:\\Users\\Nelida\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //Paso1 Ir a la página https://www.saucedemo.com
        driver.get("http://www.saucedemo.com/");
        //Paso2 Escribir el username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Paso3 Escribir el password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Paso 4 Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();
        // Paso 5 Agregar al carrito el producto Sauce Labs Onesie
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        //Validamos que, al agregar el producto, se visualiza el botón REMOVE
        try {
        boolean visible = driver.findElement(By.id("remove-sauce-labs-onesie")).isDisplayed();
        System.out.println(visible);
            if (visible == true){
                System.out.println("El boton es visible");
            }
            driver.findElement(By.id("remove-sauce-labs-onesie")).click();
        } catch (Exception e) {
            System.out.println("El boton no es visible");
        }
        driver.close();


    }
}
