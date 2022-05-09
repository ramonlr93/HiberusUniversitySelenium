package com.hiberus.university.selenium.Inventario;

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

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ValidarNumeroResultadosTest {
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

    //Ejercicio obtenido de la rama de Rubén García

    @Test
    public void sortInventoryAlphabeticalOrderTest() {
        // Paso 1
        // Ir a la página https://www.saucedemo.com
        driver.get("https://www.saucedemo.com/");

        // Paso 2
        // Escribir el username standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Paso 3
        // Escribir el password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Paso 4
        // Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();

        // Implementacion logica necesaria para el Paso 6
        // Obtenemos el listado de elementos mostrado dado que esta ordenado por defecto con el filtro (A to Z)
        List<WebElement> inventoryResultsAtoZ = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> nameInventoryResultsAtoZ = new ArrayList<>();

        // Almacenamos los nombres de los productos en una Lista
        for(int i = 0; i < inventoryResultsAtoZ.size(); i++) {
            nameInventoryResultsAtoZ.add(inventoryResultsAtoZ.get(i).getText());
        }

        // Paso 5
        //  Seleccionar el filtro NAME (Z TO A)
        Select selectOption = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selectOption.selectByValue("za");

        // Implementacion logica necesaria para el Paso 6
        // Obtenemos el listado de elementos mostrado -- Filtro ya aplicado NAME (Z to A)
        List<WebElement> inventoryResultsZtoA = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> nameInventoryResultsZtoA = new ArrayList<>();

        // Almacenamos los nombres de los productos de la nueva lista
        for(int i = 0; i < inventoryResultsZtoA.size(); i++) {
            nameInventoryResultsZtoA.add(inventoryResultsZtoA.get(i).getText());
        }

        //Revertimos la lista ordenada (A to Z), de este modo se convertira en el resultado esperado
        Collections.reverse(nameInventoryResultsAtoZ);

        // Paso 6
        // Validar que el filtro seleccionado, ordena por el orden alfabético de la Z a la A
        Assert.assertEquals("EL FILTRO 'Name (Z to A)', NO FUNCIONA CORRECTAMENTE. ", nameInventoryResultsAtoZ, nameInventoryResultsZtoA);
    }

    /**
     *    Validar el filtro de ordenamiento de precio de Menor a Mayor
     */
    @Test
    public void sortInventoryAlphabeticalPriceTest() {
        // Paso 1
        // Ir a la página https://www.saucedemo.com
        driver.get("https://www.saucedemo.com/");

        // Paso 2
        // Escribir el username standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Paso 3
        // Escribir el password secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Paso 4
        // Pulsar en el botón del Login
        driver.findElement(By.id("login-button")).click();

        // Paso 5
        //  Seleccionar el filtro 'Price (high to low)'
        Select selectOptionHilo = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selectOptionHilo.selectByValue("hilo");

        // Implementacion logica necesaria para el Paso 6
        // Obtenemos el listado de elementos mostrado -- Filtro aplicado 'Price (high to low)'
        List<WebElement> inventoryResultsHighToLow = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> priceInventoryResultsHighToLow = new ArrayList<>();

        // Almacenamos los precios de los productos de la nueva lista
        for(int i = 0; i < inventoryResultsHighToLow.size(); i++) {
            priceInventoryResultsHighToLow.add(Double.parseDouble(inventoryResultsHighToLow.get(i).getText().replace("$", "").trim()));
        }

        // Comparamos los valores de la lista
        Comparator<Double> comparator = (x, y) -> Double.compare(x, y);

        // Ordenamos de menor a mayor los valores comparados de la lista
        priceInventoryResultsHighToLow.sort(comparator);

        // Seleccionar el filtro 'Price (low to high)'
        Select selectOptionLohi = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selectOptionLohi.selectByValue("lohi");

        // Obtenemos el listado de elementos mostrado -- Filtro aplicado 'Price (low to high)'
        List<WebElement> inventoryResultsLowToHigh = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> priceInventoryResultsLowToHigh = new ArrayList<>();

        // Almacenamos los precios de los productos de la nueva lista
        for(int i = 0; i < inventoryResultsLowToHigh.size(); i++) {
            priceInventoryResultsLowToHigh.add(Double.parseDouble(inventoryResultsLowToHigh.get(i).getText().replace("$", "").trim()));
        }

        // Paso 6
        // Validar que el filtro seleccionado, ordena por el orden de precio de menor a mayor
        Assert.assertEquals("EL FILTRO 'Price (low to high)', NO FUNCIONA CORRECTAMENTE. ", priceInventoryResultsHighToLow, priceInventoryResultsLowToHigh);
    }

    @After
    public void tearDown() {
        driver.close();
    }




}
