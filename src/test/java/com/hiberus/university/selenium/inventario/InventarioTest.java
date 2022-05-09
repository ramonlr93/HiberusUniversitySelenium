package com.hiberus.university.selenium.inventario;

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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InventarioTest {

    public static WebDriver driver;
    public static WebDriverWait wait;


    @Before
    public void setUp() {
        // Paso 0
        String userProfile = "C:\\Users\\migue\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        WebDriverManager.chromedriver().setup(); //cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); //crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10, 500);

    }

    @Test
    public void ValidarNumeroResultadosTest() {

        driver.get("https://www.saucedemo.com");
        //Thread.sleep(2000);


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Thread.sleep(2000);


        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Thread.sleep(2000);


        driver.findElement(By.id("login-button")).click();
        //Thread.sleep(2000);


        List<WebElement> list = driver.findElements(By.xpath("//div[@class='inventory_item']"));

        Assert.assertEquals("No se muestran 6 articulos", 6, list.size());


    }

    @Test
    public void ValidarProductoTest() {

        driver.get("https://www.saucedemo.com");
        //Thread.sleep(2000);


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Thread.sleep(2000);


        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Thread.sleep(2000);


        driver.findElement(By.id("login-button")).click();
        //Thread.sleep(2000);

        WebElement driver1 = driver.findElement(By.id("item_1_title_link"));

        Assert.assertTrue("NO APARECE EL ELEMENTO Sauce Labs Bolt T-Shirt", driver1.isDisplayed());

    }

    @Test
    public void AgregarProductoTest() {

        driver.get("https://www.saucedemo.com");
        //Thread.sleep(2000);


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Thread.sleep(2000);


        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Thread.sleep(2000);


        driver.findElement(By.id("login-button")).click();
        //Thread.sleep(2000);

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        WebElement carrito = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));


        Assert.assertEquals("No se añade al carrito", "1", carrito.getText());

    }


    @Test
    public void EliminarProductoTest() {

        driver.get("https://www.saucedemo.com");
        //Thread.sleep(2000);


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Thread.sleep(2000);


        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Thread.sleep(2000);


        driver.findElement(By.id("login-button")).click();
        //Thread.sleep(2000);

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();

        WebElement carrito = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));

        Assert.assertEquals("No se añade al carrito", "", carrito.getText());

    }

    @Test
    public void AgregarProductosTest() {

        driver.get("https://www.saucedemo.com");
        //Thread.sleep(2000);


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Thread.sleep(2000);


        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Thread.sleep(2000);


        driver.findElement(By.id("login-button")).click();
        //Thread.sleep(2000);

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();

        WebElement carrito = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));

        Assert.assertEquals("No se añade al carrito", "3", carrito.getText());

    }

    @Test
    public void OrdenarAlfabInventarioTest() {

        driver.get("https://www.saucedemo.com");
        //Thread.sleep(2000);


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Thread.sleep(2000);


        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Thread.sleep(2000);


        driver.findElement(By.id("login-button")).click();
        //Thread.sleep(2000);

        List<WebElement> listaOrdenada = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        driver.findElement(By.xpath("//option[@value='za']")).click();

        List<WebElement> listaAlfabInversa = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        String[] lista2 = new String[6];
        String[] lista3 = new String[6];

        for(int i = 0;listaAlfabInversa.size() > i;i++){
            lista2[i]=listaAlfabInversa.get(i).getText();
            System.out.println(lista2[i]);
        }

        for(int i = 0;listaOrdenada.size() > i;i++){
            lista3[i]=listaOrdenada.get(i).getText();
            System.out.println(lista3[i]);
        }

        Arrays.sort(lista3, Collections.reverseOrder());

        Assert.assertArrayEquals("No se muestran 6 articulos", lista2, lista3);

    }

    @Test
    public void OrdenarPrecioMenorMayorInventarioTest() {

        driver.get("https://www.saucedemo.com");
        //Thread.sleep(2000);


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Thread.sleep(2000);


        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Thread.sleep(2000);


        driver.findElement(By.id("login-button")).click();
        //Thread.sleep(2000);

        List<WebElement> lista = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        driver.findElement(By.xpath("//option[@value='lohi']")).click();

        List<WebElement> listaPrecios = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        Double[] lista2 = new Double[6];
        Double[] listaPrecios2 = new Double[6];

        for(int i = 0;lista.size() > i;i++){
            lista2[i]= Double.valueOf(lista.get(i).getText().substring(1));
            System.out.println(lista2[i]);
        }

        for(int i = 0;listaPrecios.size() > i;i++){
            listaPrecios2[i]= Double.valueOf(listaPrecios.get(i).getText().substring(1));
            System.out.println(listaPrecios2[i]);
        }

        Arrays.sort(lista2);

        Assert.assertArrayEquals("No se muestran los artículos ordenados de menor a mayor", lista2, listaPrecios2);
    }

    @Test
    public void OrdenarPrecioMayorMenorInventarioTest() {

        driver.get("https://www.saucedemo.com");
        //Thread.sleep(2000);


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Thread.sleep(2000);


        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Thread.sleep(2000);


        driver.findElement(By.id("login-button")).click();
        //Thread.sleep(2000);

        List<WebElement> lista = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        driver.findElement(By.xpath("//option[@value='hilo']")).click();

        List<WebElement> listaPrecios = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        Double[] lista2 = new Double[6];
        Double[] listaPrecios2 = new Double[6];

        for(int i = 0;lista.size() > i;i++){
            lista2[i]= Double.valueOf(lista.get(i).getText().substring(1));
            System.out.println(lista2[i]);
        }

        for(int i = 0;listaPrecios.size() > i;i++){
            listaPrecios2[i]= Double.valueOf(listaPrecios.get(i).getText().substring(1));
            System.out.println(listaPrecios2[i]);
        }

        Arrays.sort(lista2, Collections.reverseOrder());

        Assert.assertArrayEquals("No se muestran los artículos ordenados de mayor a menor", lista2, listaPrecios2);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}