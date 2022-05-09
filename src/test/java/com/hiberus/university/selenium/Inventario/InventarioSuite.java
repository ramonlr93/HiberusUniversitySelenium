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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class InventarioSuite
{
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp(){
        // Inicie un nuevo navegador Chrome ->
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);


        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver,10,500);
    }

    @Test
    public void testExisteProducto(){
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"))));

        boolean itemShow = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).isDisplayed();

        Assert.assertTrue("PRUEBA FALLIDA - NO SE MUESTRA EL PRODUCTO", itemShow);
    }

    @Test
    public void testValidateNumberResults(){
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='inventory_item']"))));

        List<WebElement> listaNumItems = driver.findElements(By.xpath("//div[@class='inventory_item']"));

        int numItems = listaNumItems.size();

        Assert.assertEquals("PRUEBA FALLIDA - NÚMERO DE ITEMS INCORRECTO", 6, numItems);
    }

    @Test
    public void agregar1Producto01() {
        driver.get("https://www.saucedemo.com/");

        String username = "standard_user";
        String password = "secret_sauce";

        //driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

        String productNumber = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
        Assert.assertEquals("PRUEBA FALLIDA - NO HAY 1 PRODUCTOS","1", productNumber);
    }

    @Test
    public void agregar1Producto02() {
        driver.get("https://www.saucedemo.com/");

        String username = "standard_user";
        String password = "secret_sauce";

        //driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

        int sizeShoppingCArt = driver.findElements(By.xpath("//a[@class='shopping_cart_link']//child::*")).size();

        Assert.assertEquals("PRUEBA FALLIDA - NO HAY 1 PRODUCTOS",1, sizeShoppingCArt);
    }

    @Test
    public void eliminarProductoCarrito(){
        driver.get("https://www.saucedemo.com/");

        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();

        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bolt-t-shirt']")).click();


        int sizeShoppingCart = driver.findElements(By.xpath("//a[@class='shopping_cart_link']//child::*")).size();

        Assert.assertEquals("PRUEBA FALLIDA - SE MUESTRA UN ELEMENTO EN EL CARRITO",0, sizeShoppingCart);
    }


    @Test
    public void agregar3Productos01() {
            driver.get("https://www.saucedemo.com/");

            String username = "standard_user";
            String password = "secret_sauce";

            //driver.findElement(By.id("user-name")).sendKeys(username);
            driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

            driver.findElement(By.id("login-button")).click();

            driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
            driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
            driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();

            String productNumber = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
            Assert.assertEquals("PRUEBA FALLIDA - NO HAY 3 PRODUCTOS","3", productNumber);
    }

    @Test
    public void agregar3Productos02() {
        driver.get("https://www.saucedemo.com/");

        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();

        String productNumber = driver.findElements(By.xpath("//a[@class='shopping_cart_link']//child::*")).get(0).getText();
        Assert.assertEquals("PRUEBA FALLIDA - NO HAY 3 PRODUCTOS","3", productNumber);
    }


    @Test
    public void ordenarInventarioAlfabZA(){
        driver.get("https://www.saucedemo.com/");

        String username = "standard_user";
        String password = "secret_sauce";

        //driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        // Obtenemos lista de elementos por defecto (filtro A to Z)
        List<WebElement> listaProductosAtoZ = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> nombresListaProductosAtoZ = new ArrayList<String>();

        // Con un bucle recorremos los nombres de los productos y lo añadimos a una lista:ç
        for(int i = 0; i < listaProductosAtoZ.size(); i++){
            nombresListaProductosAtoZ.add(listaProductosAtoZ.get(i).getText());
        }

        // Seleccionamos la opción del filtro NAME (Z to A)
        Select selectOption = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selectOption.selectByValue("za");

        // Obtenemos lista de elementos por defecto (filtro A to Z)
        List<WebElement> listaProductosZtoA = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> nombresListaProductosZtoA = new ArrayList<String>();

        for(int i = 0; i < listaProductosZtoA.size(); i++){
            nombresListaProductosZtoA.add(listaProductosZtoA.get(i).getText());
        }

        // Revertimos la lista para comparar que las dos listas sean iguales
        Collections.reverse(nombresListaProductosAtoZ);

        // Validar con un Assert que las listas son iguales
        Assert.assertEquals("PRUEBA FALLIDA - PRODUCTOS NO ORDENADOS DE Z TO A", nombresListaProductosAtoZ, nombresListaProductosZtoA);

    }

    @Test
    public void ordenarInventarioLowToHigh01() {
    driver.get("https://www.saucedemo.com/");

    String username = "standard_user";
    String password = "secret_sauce";

    driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

    driver.findElement(By.id("login-button")).click();

    // Seleccionamos la opción del filtro PRICE (high to low)
    Select selectOption01 = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
    selectOption01.selectByValue("hilo");

    // Obtenemos lista de elementos por defecto (filtro Price (high to low))
    List<WebElement> listaProductosHighToLow = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
    List<String> nombresListaProductosHighToLow = new ArrayList<String>();

    // Con un bucle recorremos los nombres de los productos y lo añadimos a una lista:
    for(WebElement listaPrecios01: listaProductosHighToLow){
        nombresListaProductosHighToLow.add(listaPrecios01.getText());
    }

    Collections.reverse(nombresListaProductosHighToLow);

    // Seleccionamos la opción del filtro PRICE (low to high)
    Select selectOption = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
    selectOption.selectByValue("lohi");

    // Obtenemos lista de elementos por defecto (filtro Price (low to high))
    List<WebElement> listaProductosLowToHigh = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
    List<String> nombresListaProductosLowToHigh = new ArrayList<String>();

    for(WebElement listaPrecios02: listaProductosLowToHigh){
        nombresListaProductosLowToHigh.add(listaPrecios02.getText());
    }

    // Validar con un Assert que las listas son iguales
    Assert.assertEquals("PRUEBA FALLIDA - PRODUCTOS NO ORDENADOS DE LOW TO HIGH", nombresListaProductosHighToLow, nombresListaProductosLowToHigh);

    }



    @After
    public void quitDriver(){
       driver.quit();
    }

}
