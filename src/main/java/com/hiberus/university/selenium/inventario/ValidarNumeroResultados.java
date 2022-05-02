package com.hiberus.university.selenium.inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ValidarNumeroResultados {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //Paso 0
        String userProfile = "C:\\Users\\usuario\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile); //Añadimos los argumentos del perfil

        driver = new ChromeDriver(options);       //Inicializamos el driver
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();      //Maximiza la ventana

        //Paso 1 Ir a la web
        driver.get("https://www.saucedemo.com/");
        /* Thread.sleep(2000); */

        //Paso 2 Escribir el username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Paso 3 Escribir el password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Paso 4 Pulsar en el boton del Login
        WebElement clickButton = driver.findElement(By.id("login-button"));
        clickButton.click();

        //Paso 5 Validar que el número de productos mostrados es igual a 6

        List<WebElement> xpath = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        int numProductos = xpath.size();

        if (numProductos == 6) {
            System.out.println("El número de productos mostrados es " + numProductos + " .Es lo correcto ");
        } else {
            System.out.println("El número de productos mostrados: " + numProductos + " .No es correcto ");
        }

        TimeUnit.SECONDS.sleep(2);
        driver.quit();
    }
}




