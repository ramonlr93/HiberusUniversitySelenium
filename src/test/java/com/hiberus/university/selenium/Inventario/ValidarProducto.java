package com.hiberus.university.selenium.Inventario;

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
import java.util.concurrent.TimeUnit;

public class ValidarProducto {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        //Paso0
        String userProfile = "C:\\Users\\scasado\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,10,500);
    }

    @Test
    public void ValidarProductoInventario() {
        //Paso1 Ir a la pagina
        driver.get("https://www.saucedemo.com/");
        //Paso2 Escribir el username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Paso3 Escribir el password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Paso 4. Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();
        //Paso5 Validamos producto COPIADO RUBEN
        List<WebElement> inventoryResults = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        boolean isProductPresent = false;
        for(int i = 0; i < inventoryResults.size(); i++) {
            if(inventoryResults.get(i).getText().equals("Sauce Labs Bolt T-Shirt")) {
                isProductPresent = true;
            }
        }
        //ME DA ERROR JAVA ; EXPECTED LINEA 58 Y REACHED END OF FILE WHILE PARSING Y NO CONSIGO CORREGIRLO, PESE A COPIARLO DEL RESTO
        @After
        public void quitDriver; () { driver.quit(); }
    }