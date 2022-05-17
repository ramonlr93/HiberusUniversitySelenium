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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartSuiteTest {

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
    public void removeCartProductTest() {
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

            if(count < 2) {
                selectValue.add(pos);
                count++;
            }
        }

        // Añadir al carrito los articulos seleccionados al azar
        for(int i = 0; i < selectValue.size(); i++) {
            inventoryResults.get(selectValue.get(i)).click();
        }

        // Ir al carrito
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        // Implementacion del codigo para preparar la validacion y eliminacion del producto deseado
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@class= 'cart_item']"))));
        List<WebElement> listProductCart = driver.findElements(By.xpath("//div[@class= 'cart_item']"));

        //Almacenar el nombre del producto el cual se va a eliminar
        String nameDeleteProduct = listProductCart.get(0).findElement(By.xpath(".//descendant::div[@class='inventory_item_name']")).getText();

        // Eliminar el producto seleccionado en el paso anterior
        listProductCart.get(0).findElement(By.xpath("//descendant::button[contains(@id,'remove')]")).click();

        // Implementacion del codigo para la validacion de la eliminacion del producto seleccionado
        List<WebElement> listActualProductCart = driver.findElements(By.xpath("//div[@class= 'cart_item']"));
        String nameActualProductCart = listActualProductCart.get(0).findElement(By.xpath(".//descendant::div[@class='inventory_item_name']")).getText();

        boolean isDeleteProduct;
        if(nameDeleteProduct.equals(nameActualProductCart)) {
            isDeleteProduct = false;
        } else {
            isDeleteProduct = true;
        }

        // Validar que el producto eliminado, no aparece en el carrito
        Assert.assertTrue("EL PRODUCTO QUE SE DESEABA ELIMINAR, NO SE HA ELIMINADO DEL CARRITO", isDeleteProduct);

    }

    @After
    public void tearDown() {
        driver.close();
    }

}