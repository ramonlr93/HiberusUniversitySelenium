package com.hiberus.university.selenium.CarritoSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class EliminarDesdeCarrito {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {

        setUpDriver();
        wait = new WebDriverWait(driver, 10, 500);
        authenticateSauceDemo();

    }

    @Test
    public void TestAnadirUnProductoAlCarrito() throws InterruptedException {
        //Paso 5. Añadir al carrito 2 productos al azar
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"))));
            WebElement camisa = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
            camisa.click();
            WebElement mono = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
            mono.click();

            //Paso 6. Ir al carrito
            driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
            List<WebElement> articulosCarrito = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
            List<String> carrito2articulos = new ArrayList<String>();
            for (WebElement articulo : articulosCarrito) {
                carrito2articulos.add(articulo.getText());
                //System.out.println(articulo.getText());
            }

            //Paso 7. Eliminar un producto desde el carrito
            driver.findElement(By.id("remove-sauce-labs-onesie")).click();
            List<WebElement> articulosCarrito1 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
            List<String> carrito1articulo = new ArrayList<String>();
            for (WebElement articulo1 : articulosCarrito1) {
                carrito1articulo.add(articulo1.getText());
                //System.out.println(articulo1.getText());
            }

            //Paso 8. Validar que se ha eliminado el sauce-labs-onesie
            boolean isMonoDeleted = !carrito1articulo.contains("Sauce Labs Onesie"); //No lo contenga con el !
            Assert.assertTrue("El producto mono SI se encuentra en el carrito", isMonoDeleted);
        } catch (
                NoSuchElementException e) {
        }
    }

    @After
    public void TearDown() {
        driver.close();
    }

    private void setUpDriver() {
        String rutadriver = "C:\\Program Files\\Google\\Chrome\\Application\\101.0.4951.54";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + rutadriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    private void authenticateSauceDemo() {
        //Paso1. Ir a la página Sauce
        String urlSauce = "https://www.saucedemo.com/";
        driver.get(urlSauce);

        //Paso 2. Escribir username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Paso 3. Escribir password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Paso 4. Pulsar boton login
        driver.findElement(By.id("login-button")).click();
    }

}
