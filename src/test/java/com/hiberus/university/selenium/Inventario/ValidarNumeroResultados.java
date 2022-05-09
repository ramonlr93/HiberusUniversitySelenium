package com.hiberus.university.selenium.Inventario;

import com.fasterxml.jackson.databind.type.CollectionType;
import driver.get;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;


public class ValidarNumeroResultados {
    public static WebDriver driver;

    @Before
    public void setupClass() {
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @Test
    public void validarNumero() {

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Paso 5 Obtener elnúmero de resultados
        List<WebElement> lista = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));

        Assert.assertEquals("El número de resultados no es 6", 6, lista.size());

    }

    @Test
    public void validarCamiseta() {

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        boolean aparece;

        try {
            driver.findElement(By.xpath("//a[@id = 'item_5_title_link']/ancestor:: div[@class = 'inventory_item']"));
            aparece = true;
        } catch (NoSuchElementException e) {
            aparece = false;
        }

        Assert.assertTrue("No existe esta prenda", aparece);


    }

    @Test
    public void angadirPrenda() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        String carrito;
        carrito = driver.findElement(By.xpath("//span[@class = 'shopping_cart_badge']")).getText();

        Assert.assertEquals("No es esa cantidad", "1", carrito);
    }

    @Test
    public void eliminarDesdeInventario() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();

        //Con este metodo indicamos que si no aparece el carrito es true

        boolean CarritoVacio;

        try {
            driver.findElement(By.xpath("//span[@class = 'shopping_cart_badge']"));
            CarritoVacio = false;
        } catch (NoSuchElementException e) {
            CarritoVacio = true;
        }


        Assert.assertTrue("No se ha eliminado la camiseta", CarritoVacio);
    }

    @Test

    public void agregarTresProductos() {


        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        String carrito;
        carrito = driver.findElement(By.xpath("//span[@class = 'shopping_cart_badge']")).getText();
        // Estas validando que el numero del carrito es uno específico (ejemplo 3)

        //Aqui estas diciendo que si el carrito NO muestra 3, se visualiza el mensaje no especificado
        Assert.assertEquals("No es esa cantidad", "3", carrito);


    }

    @Test
    public void ordenarAZ() {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        //Implementación logica necesaria para el PASO 6
        //Obtenemos el listado de elemantos mostrado dado que esta ordenado por defecto con el filtro (A to Z)
        List<WebElement> inventoryResultssAtoZ = driver.findElements(By.xpath("//div[class='iventory_item_name']"));
        List<String> nameInventoryResultsAtoZ = new ArrayList<>();

        //Almacenamos los nombres de los productos en una lista
        for (int i=0; i <inventoryResultssAtoZ.size(); i++){
            nameInventoryResultsAtoZ.add(inventoryResultssAtoZ.get(i).getText());
        }

        //Paso 5
        //Seleccionar el filtro NAME (Z TO A)
        Select selectOptions = new Select(driver.findElement(By.xpath("//select[class='product_sort_container']")));
        selectOptions.selectByValue("za");

        //Implementación logica necesaria para el Paso 6
        //Obtenemos el listado de elementos mostrado -- Filtro ya aplicado NAME (Z to A)
        List<WebElement> inventoryResultsZtoA = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> nameInventoryResultsZtoA = new ArrayList<>();

        //Almacenamos los nombres de los productos de la nueva lista
        for (int i=0; i <inventoryResultsZtoA.size(); i++){
        nameInventoryResultsZtoA.add(inventoryResultsZtoA.get(i).getText());

        //Revertimos la lista ordenada (A to Z), de este modo se convertirá en el resultados esperado
            Collections.reverse(nameInventoryResultsAtoZ);


            // Paso 6
            //Validar que el filtro seleccionado, ordena por el orden alfabçeitco de la Z a la A
            Assert.assertEquals("El filtro 'Name (Z to A)', NO FUNCIONA CORRECTAMENTE. ", nameInventoryResultsAtoZ, nameInventoryResultsZtoA);

        }
    }

    //@Test
    public void ordenarMenorMayor(){
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Implementación logica necesaria para el PASO 6
        //Obtenemos el listado de elemantos mostrado dado que esta ordenado por defecto con el filtro (menor a mayor)
        List<WebElement> inventoryPriceMenorMayor = driver.findElements(By.xpath("//div[class='iventory_item_price']"));
        List<String> inventoryResultsMenorMayor = new ArrayList<>();

        //Almacenamos los precios de los productos en una lista
        for (int i=0; i <inventoryPriceMenorMayor.size(); i++){
            inventoryResultsMenorMayor.add(inventoryPriceMenorMayor.get(i).getText());



    }




    @After
    public void tearDom() {
        driver.quit();
    }
}