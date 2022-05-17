package com.hiberus.university.selenium.checkout;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckoutSuiteTest {

    public static WebDriver driver;

    public static WebDriverWait wait;

    @Before
    public void setUp() {
        //Paso0
        WebDriverManager.chromedriver().setup(); // Cargar Chromedriver

        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);
    }

    @Test
    public void checkPriceProductsTest() {
        // Ir a la página https://www.saucedemo.com
        driver.get("https://www.saucedemo.com/");

        // Escribir el username standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Escribir el password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();

        // Agregar al carrito los 3 productos elegidos al azar
        List<WebElement> inventoryResults = driver.findElements(By.xpath("//button[contains(@id, 'add-to-cart')]"));

        /*
         * Bucle que almacena en el Array selectValue, el valor de los productos seleccionados al azar
         */
        ArrayList<Integer> selectValue = new ArrayList<>();
        int pos;
        int count = 0;
        for(int  i = 0; i < inventoryResults.size(); i++) {
            pos = (int) Math.floor(Math.random() * inventoryResults.size());

            while (selectValue.contains(pos)) {
                pos = (int) Math.floor(Math.random() * inventoryResults.size());
            }

            if(count < 3) {
                selectValue.add(pos);
                count++;
            }
        }

        // Añadir al carrito los articulos seleccionados al azar y extraer su precio
        List<String> listPriceProducts = new ArrayList<>();
        for(int i = 0; i < selectValue.size(); i++) {
            listPriceProducts.add(inventoryResults.get(selectValue.get(i)).findElement(By.xpath(".//preceding-sibling::div[@class='inventory_item_price']")).getText());
            inventoryResults.get(selectValue.get(i)).click();
        }

        // Ir al carrito
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        // Realizar el checkout del producto
        driver.findElement(By.id("checkout")).click();

        // Rellenar datos del checkout y continuar.
        driver.findElement(By.id("first-name")).sendKeys("Ruben");
        driver.findElement(By.id("last-name")).sendKeys("Garcia");
        driver.findElement(By.id("postal-code")).sendKeys("50009");
        driver.findElement(By.id("continue")).click();

        // Validar que el precio total del pedido (Item total) es la suma del importe de los productos seleccionados en el inventario
        List<Double> pricesProducts = new ArrayList<>();

        for(int i = 0; i < listPriceProducts.size(); i++) {
            pricesProducts.add(Double.parseDouble(listPriceProducts.get(i).replace("$", "").trim()));
        }

        double value = 0;

        for(int i = 0; i < pricesProducts.size(); i++) {
            value += pricesProducts.get(i);
        }

        String totalValueActual = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText();
        totalValueActual = totalValueActual.replace("Item total: $", "").trim();

        Assert.assertEquals("LA SUMA DE LOS PRECIOS DE LOS PRODUCTOS NO ES LA MISMA", String.valueOf(value), totalValueActual);
    }

    @Test
    public void placeOrderTest() {
        // Ir a la página https://www.saucedemo.com
        driver.get("https://www.saucedemo.com/");

        // Escribir el username standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Escribir el password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();

        // Agregar al carrito los 3 productos elegidos al azar
        List<WebElement> inventoryResults = driver.findElements(By.xpath("//button[contains(@id, 'add-to-cart')]"));

        /*
         * Bucle que almacena en el Array selectValue, el valor de los productos seleccionados al azar
         */
        ArrayList<Integer> selectValue = new ArrayList<>();
        int pos;
        int count = 0;
        for(int  i = 0; i < inventoryResults.size(); i++) {
            pos = (int) Math.floor(Math.random() * inventoryResults.size());

            while (selectValue.contains(pos)) {
                pos = (int) Math.floor(Math.random() * inventoryResults.size());
            }

            if(count < 3) {
                selectValue.add(pos);
                count++;
            }
        }

        // Añadir al carrito los articulos seleccionados al azar y extraer su precio
        List<String> listPriceProducts = new ArrayList<>();
        for(int i = 0; i < selectValue.size(); i++) {
            listPriceProducts.add(inventoryResults.get(selectValue.get(i)).findElement(By.xpath(".//preceding-sibling::div[@class='inventory_item_price']")).getText());
            inventoryResults.get(selectValue.get(i)).click();
        }

        // Ir al carrito
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        // Realizar el checkout del producto
        driver.findElement(By.id("checkout")).click();

        // Rellenar datos del checkout y continuar.
        driver.findElement(By.id("first-name")).sendKeys("Ruben");
        driver.findElement(By.id("last-name")).sendKeys("Garcia");
        driver.findElement(By.id("postal-code")).sendKeys("50009");
        driver.findElement(By.id("continue")).click();

        // Finalizar el checkout
        driver.findElement(By.id("finish")).click();

        // Validar que el pedido a finalizado correctamente mostrando el mensaje “Your order has been dispatched, and will arrive just as fast as the pony can get there!”
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='complete-text']"))));
        String orderCompletedMessage = driver.findElement(By.xpath("//div[@class='complete-text']")).getText();

        Assert.assertEquals("EL MENSAJE FINAL DEL PEDIDO REALIZADO NO ES EL CORRECTO ",
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!", orderCompletedMessage);

    }

    @After
    public void tearDown() {
        driver.close();
    }

}