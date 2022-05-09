package com.hiberus.university.selenium;

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

import java.util.*;
import java.util.concurrent.TimeUnit;

public class InventarioSuite {
    public static WebDriver driver;

    @Before
    public void SetUp() {
        String userProfile = "C:\\Users\\ander\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
    }

    @Test
    public void testNumeroInventario() throws  InterruptedException {
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 2, 500);
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Validacion
        int numeroObjetos = driver.findElements(By.xpath("//div[@class='inventory_item']")).size();
        Assert.assertEquals("PRUEBA FALLADA-El numero de objetos en el inventario deberia ser 6",
                6, numeroObjetos);
    }

    @Test
    public void testMostrarObjetoInventario() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Validacion
        boolean verdadero;
        try{
            verdadero = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Bolt T-Shirt')]")).isDisplayed();
        }catch(Exception exception){
            verdadero = false;
        }
        Assert.assertTrue("PRUEBA FALLADA-El objeto Sauce Labs Bolt T-Shirt no aparece en el inventario"
                , verdadero);
    }

    @Test
    public void testIncrementarCarrito() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Validacion
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        String valorCarrito = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
        Assert.assertEquals("PRUEBA FALLADA-No se ha incrementado el carrito",
                "1", valorCarrito);
    }

    @Test
    public void testEliminarCarrito() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Validacion
        String valorCarrito;
        try{
            driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
            valorCarrito = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
        }catch (Exception exception){
           valorCarrito = "0";
        }
        Assert.assertEquals("PRUEBA FALLADA-No se ha incrementado el carrito",
                "1", valorCarrito);
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
        valorCarrito = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
        Assert.assertEquals("PRUEBA FALLADA-No se ha borrado el producto del carrito",
                "", valorCarrito);
    }

    @Test
    public void testIncrementarCarrito3() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Validacion
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        String valorCarrito = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();
        Assert.assertEquals("PRUEBA FALLADA-No se ha incrementado el carrito 3 veces",
                "3", valorCarrito);
    }

    @Test
    public void testOrdenarAlfabeticamenteZA() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Validacion
        List<WebElement> listaAZ = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='za']")).click();
        List<WebElement> listaZA = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        Collections.reverse(listaAZ);
        Assert.assertEquals("PRUEBA FALLADA-No se ha ordenado de Z a A",
                listaAZ, listaZA);
    }

    @Test
    public void testOrdenarMenorMayorPrecio() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Validacion
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='lohi']")).click();
        List<WebElement> listaMenorMayor = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        ArrayList<Double> listaOrdenada = new ArrayList<Double>();
        ArrayList<Double> listaMenorMayor1 = new ArrayList<Double>();
        for(int i = 0; i < 6; i++){
            listaOrdenada.add(Double.valueOf(listaMenorMayor.get(i).getText().substring(1)));
            listaMenorMayor1.add(Double.valueOf(listaMenorMayor.get(i).getText().substring(1)));
        }
        Collections.sort(listaOrdenada);
        Assert.assertEquals("PRUEBA FALLADA-No se ha ordenado de menor a mayor precio",
                listaOrdenada, listaMenorMayor1);
    }

    @Test
    public void testOrdenarMayorMenorPrecio() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Validacion
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='hilo']")).click();
        List<WebElement> listaMayorMenor = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        ArrayList<Double> listaOrdenada = new ArrayList<Double>();
        ArrayList<Double> listaMayorMenor1 = new ArrayList<Double>();
        for(int i = 0; i < 6; i++){
            listaOrdenada.add(Double.valueOf(listaMayorMenor.get(i).getText().substring(1)));
            listaMayorMenor1.add(Double.valueOf(listaMayorMenor.get(i).getText().substring(1)));
        }
        Collections.sort(listaOrdenada);
        Collections.reverse(listaOrdenada);
        Assert.assertEquals("PRUEBA FALLADA-No se ha ordenado de menor a mayor precio",
                listaOrdenada, listaMayorMenor1);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}