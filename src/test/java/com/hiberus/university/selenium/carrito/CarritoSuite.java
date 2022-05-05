package com.hiberus.university.selenium.carrito;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CarritoSuite {

    public static WebDriver driver;
    public static WebDriverWait wait;


    @Before
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void eliminarProductoDesdeElCarrito() throws InterruptedException {
        WebElement usuario;
        WebElement passwrod;
        WebElement boton;
        WebElement carrito;
        WebElement botonEliminarCarrito;
        List<WebElement> botonAdd;
        List<WebElement> objetosCarrito;
        List<WebElement> objetosCarritoEliminado;
        int valorAleatorio;
        int valorAleatorio2;
        driver.get("https://www.saucedemo.com");
        usuario = driver.findElement(By.id("user-name"));
        passwrod = driver.findElement(By.id("password"));
        boton = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        passwrod.sendKeys("secret_sauce");
        boton.click();
        botonAdd=driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        valorAleatorio = (int) (Math.random()*botonAdd.size());
        botonAdd.get(valorAleatorio).click();
        valorAleatorio2 = (int) (Math.random()*botonAdd.size());
        if(valorAleatorio2!=valorAleatorio){
            botonAdd.get(valorAleatorio2).click();
        }else{
            while(valorAleatorio2==valorAleatorio){
                valorAleatorio2 = (int) (Math.random()*botonAdd.size());;
            }
            botonAdd.get(valorAleatorio2).click();
        }
        carrito = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        carrito.click();
        objetosCarrito = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        botonEliminarCarrito = driver.findElement(By.xpath("//button[@class='btn btn_secondary btn_small cart_button']"));
        botonEliminarCarrito.click();
        objetosCarritoEliminado =  driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        Assert.assertNotEquals("No se ha borrado correctamente",objetosCarrito,objetosCarritoEliminado);
    }

    @After
    public void clsoeDriver() {
        driver.close();
    }
}
