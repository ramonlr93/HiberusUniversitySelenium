package com.hiberus.university.selenium.CheckoutSuite;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RealizarPedido {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {

        setUpDriver();
        wait = new WebDriverWait(driver, 10, 500);
        authenticateSauceDemo();

    }

    @Test
    public void TestPrecioFinal() throws InterruptedException {

        //Paso 5. Añadir al carrito 1 producto al azar
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"))));
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        //Paso 6. Ir al carrito
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        //Paso 7. Realizar Checkout del producto
        driver.findElement(By.id("checkout")).click();

        //Paso 8. Rellenar datos de Checkout y continuar
        driver.findElement(By.id("first-name")).sendKeys("Katherin Paola");
        driver.findElement(By.id("last-name")).sendKeys("Sanabria Diaz");
        driver.findElement(By.id("postal-code")).sendKeys("04009");
        driver.findElement(By.id("continue")).submit();

        //Paso 9. Realizar Checkout
        driver.findElement(By.id("finish")).click();

        //Paso 10. Validar que el precio total (item total) e sla suma del importe de los productos selecionados
        WebElement mensajePedido = driver.findElement(By.xpath("//div[@class='complete-text']"));
        String textoMensajePedido = mensajePedido.getText();
        String mensajeEsperado = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        Assert.assertEquals("NO se muestra el mensaje de 'Your order has been dispatched, and will arrive just as fast as the pony can get there!'",mensajeEsperado,textoMensajePedido);
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
