package com.hiberus.university.selenium.InventarioSuite;

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

import java.util.List;
import java.util.NoSuchElementException;


public class ValidarProductosInventario {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        setUpDriver();
        wait = new WebDriverWait(driver, 10, 500);
        authenticateInSauceDemo();
    }

    @Test
    public void TestNumeroDeProductosInventario() throws InterruptedException {

        //Paso 5. Validar que se muestran 6 productos
        List<WebElement> list = driver.findElements(By.className("inventory_item"));
        int tLista = list.size();
        Assert.assertEquals("El número de articulos mostrado NO es 6", 6, tLista);
    }

    @Test
    public void TestProductoSauceExistente() throws InterruptedException {
//Paso 5. Validar que el producto Sacue Labs Bolt T-Shirt existe en el inventario
        boolean camisaDisplayed;
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"))));
            WebElement buyCamisa = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
            camisaDisplayed = buyCamisa.isDisplayed();
        } catch (NoSuchElementException e) {
            camisaDisplayed = false;
        }

        Assert.assertTrue("El producto Sauce Labs Bolt T-shirt no existe en el inventario", camisaDisplayed);
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

    private void authenticateInSauceDemo() {
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
