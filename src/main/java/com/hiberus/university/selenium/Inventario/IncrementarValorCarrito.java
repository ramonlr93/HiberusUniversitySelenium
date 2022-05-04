package com.hiberus.university.selenium.Inventario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class IncrementarValorCarrito {
    public static WebDriver driver;

    public static void main(String[] args) {

        //Paso0
        String userProfile = "C:\\Users\\scasado\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\v1gb2eq4.default-release";
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("user-data-dir=" + userProfile);

        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().deleteAllCookies();
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
        //Paso5 Agregar producto al carrito
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        //Paso6 Validamos que en el carrito sale valor 1
        String result = driver.findElement(By.className("shopping_cart_badge")).getText();

        if (result.equals("1")) {
            System.out.println("Hay 1 resultado");
        } else {
            System.out.println("No hay 1 resultado");
        }
        driver.quit();
    }
}

