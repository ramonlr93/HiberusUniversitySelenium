package com.hiberus.university.selenium.inventario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class IncrementoValorCarrito {

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

        //Paso 5 Agregar al carrito el producto "Sauce Labs Bolt T-Shirt"
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        WebElement clickButton2 = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        clickButton2.click();

        //Paso 6 Comprobar que en el icono "carrito" se ha agregado el valor "1"
        String numarticulos = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")
        ).getText();
        int i = Integer.parseInt(numarticulos);

        if(i == 1){
            System.out.println("El articulo se ha cargado en el carrito");
        }else {
            System.out.println("Es incorrecto. No se ha agregado el articulo.");
        }

        TimeUnit.SECONDS.sleep(2);

        //Agrego que el contador de carrito vuelva a "0" cuando termine ejecución
        WebElement remove = driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"));
        WebElement clickButton3 = driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"));
        clickButton3.click();

        driver.quit();

    }
}




















