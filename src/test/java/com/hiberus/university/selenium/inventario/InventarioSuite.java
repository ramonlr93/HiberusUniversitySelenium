package com.hiberus.university.selenium.inventario;

import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

//import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class InventarioSuite {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void SetUp() {


        String userProfile = "C:\\Users\\usuario\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile); //Añadimos los argumentos del perfil

        driver = new ChromeDriver(options);       //Inicializamos el driver
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();      //Maximiza la ventana

        wait = new WebDriverWait(driver, 10);

    }

    /**
     * Rigorous Test:-)
     */

    @Test
    public void testNumItems() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(xpath("//input[@id='login-button']")).submit();
        Thread.sleep(2000);

        List<WebElement> numProductos;

        numProductos = driver.findElements(xpath("//div[@class='inventory_item']"));

        Assert.assertEquals("NO VALIDA PORQUE NO HAY 6 ARTICULOS", 6, numProductos.size());
    }


    @Test
    public void testExisteProducto() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(xpath("//input[@id='login-button']")).submit();
        Thread.sleep(2000);

        boolean existe;
        try {
            //wait.until(ExpectedConditions.visibilityOf(
            //driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
            existe = driver.findElement(xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).isDisplayed();
        } catch (NoSuchElementException e) {
            existe = false;
        }

        Assert.assertTrue("EL PRODUCTO Sauce Labs Bolt T-Shirt NO ESTA EN EL INVENTARIO", existe);

    }

    @Test
    public void testAgregarProducto() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(xpath("//input[@id='login-button']")).submit();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        boolean agregado;
        try {
            //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"))));
            agregado = driver.findElement(xpath("//span[@class='shopping_cart_badge']")).isDisplayed();
        } catch (NoSuchElementException e) {
            agregado = false;
        }

        Assert.assertTrue("EL PRODUCTO Sauce Labs Bolt T-Shirt NO se ha agregado", agregado);
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void testEliminarProducto() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(xpath("//input[@id='login-button']")).submit();
        TimeUnit.SECONDS.sleep(2);
        //driver.findElement(id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        //TimeUnit.SECONDS.sleep(2);
        //driver.findElement(id("remove-sauce-labs-bolt-t-shirt")).click();

        boolean eliminado;
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")))).click();
            TimeUnit.SECONDS.sleep(2);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")))).click();
            TimeUnit.SECONDS.sleep(2);
            eliminado = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")))).isDisplayed();
        } catch (NoSuchElementException e) {
            eliminado = false;
        }
        TimeUnit.SECONDS.sleep(2);

        Assert.assertFalse("EL PRODUCTO Sauce Labs Bolt T-Shirt NO se ha ELIMINADO del carrito", eliminado);

    }

    @Test
    public void testAgregar3Productos() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(xpath("//input[@id='login-button']")).click();


        WebElement clickButton = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        clickButton.click();
        WebElement clickButton2 = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        clickButton2.click();
        WebElement clickButton3 = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        clickButton3.click();

        //driver.findElement(id("add-to-cart-sauce-labs-onesie")).click();
        //TimeUnit.SECONDS.sleep(2);

        //Comprobar carrito
        WebElement carrito = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        String itemsCarrito = carrito.getText();
        String itemsPrevistos = "3";
        Assert.assertEquals("En el icono carrito NO añadido 3 producto ", itemsPrevistos, itemsCarrito);

    }


    @Test
    public void testOrdenarInventario_Z_A() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(xpath("//input[@id='user-name']")).sendKeys("standard_user");

        driver.findElement(xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(xpath("//input[@id='login-button']")).click();
        Thread.sleep(2000);

        List<WebElement> listadoInventario_AZ = driver.findElements(xpath("//div[@class='inventory_item_name']"));
        List<String> listado = new ArrayList<String>();
        for (WebElement articulos : listadoInventario_AZ) {
            listado.add(articulos.getText());
            //Collections.sort((List<String>) articulos);

            System.out.println(articulos.getText());
            //Thread.sleep(2000);
            Select filtro = new Select(driver.findElement(xpath("//select[@class='product_sort_container']")));
            filtro.selectByValue("za");

        }


        List<WebElement> listadoInventario_ZA = driver.findElements(xpath("//div[@class='inventory_item_name']"));
        List<String> listado2 = new ArrayList<String>();
        for (WebElement articulos2 : listadoInventario_ZA) {
            listado2.add(articulos2.getText());

            System.out.println(articulos2.getText());


        }
        Collections.reverse(listado);
        Assert.assertEquals("EL FILTRO Z_A,FALLA", listado, listado2);
    }

    @Test
    public void testPreciosMenor_Mayor() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(xpath("//input[@id='user-name']")).sendKeys("standard_user");

        driver.findElement(xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(xpath("//input[@id='login-button']")).click();
        Thread.sleep(2000);

        Select filtro = new Select(driver.findElement(xpath("//select[@class='product_sort_container']")));
        filtro.selectByValue("lohi");


        List<WebElement> OrdenAscendetePrecios = driver.findElements(xpath("//div[@class='inventory_item_price']"));
        List<String> preciosIncrementales = new ArrayList<String>();
        for (WebElement precios : OrdenAscendetePrecios) {
            preciosIncrementales.add(precios.getText());

            System.out.println(precios.getText());

        }
    }

    @Test
    public void testPreciosMayor_Menor() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(xpath("//input[@id='user-name']")).sendKeys("standard_user");

        driver.findElement(xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(xpath("//input[@id='login-button']")).click();
        Thread.sleep(2000);

        Select filtro = new Select(driver.findElement(xpath("//select[@class='product_sort_container']")));
        filtro.selectByValue("hilo");


        List<WebElement> OrdenDescendentePrecios = driver.findElements(xpath("//div[@class='inventory_item_price']"));
        List<String> preciosDecrecientes = new ArrayList<String>();
        for (WebElement precios2 : OrdenDescendentePrecios) {
            preciosDecrecientes.add(precios2.getText());

            System.out.println(precios2.getText());
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}















