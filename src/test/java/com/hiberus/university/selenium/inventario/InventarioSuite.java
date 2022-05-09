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
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class InventarioSuite
{
    public static WebDriver driver;

    @Before
    public void setUp(){
        String userProfile= "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testResultados() throws InterruptedException
    {
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        List<WebElement> lista = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        Assert.assertEquals("FALLIDO, NO MUESTRA 6 ELEMENTOS", 6, lista.size());

    }

    @Test
    public void testExisteProducto() throws InterruptedException
    {
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        boolean isMessageErrorVisible = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).isDisplayed();

        Assert.assertTrue("PRUEBA FALLIDA, EL ELEMENTO NO APARECE", isMessageErrorVisible);
    }

    @Test
    public void testAnadirProducto() throws InterruptedException
    {
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        boolean isProductAdded = driver.findElement(By.xpath("//span[@class='shopping_cart_badge' and text() = '1']")).isDisplayed();

        Assert.assertTrue("PRUEBA FALLIDA, EL ELEMENTO NO SE HA ANADIDO", isProductAdded);
    }

    @Test
    public void testEliminarProducto() throws InterruptedException
    {

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();

        String numElementos = driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText();

        Assert.assertEquals("PRUEBA FALLIDA, EL ELEMENTO NO SE HA ELIMINADO", "", numElementos);
    }

    @Test
    public void testAnadirTres() throws InterruptedException
    {
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        boolean isProductAdded = driver.findElement(By.xpath("//span[@class='shopping_cart_badge' and text() = '3']")).isDisplayed();

        Assert.assertTrue("PRUEBA FALLIDA, NO SE HAN ANADIDO LOS PRODUCTOS", isProductAdded);
    }

    @Test
    public void testOrdenarAlfabetico() throws InterruptedException
    {

        List lista1 = new ArrayList();
        List lista2 = new ArrayList();
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        List<WebElement> listaAZ = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        Collections.reverse(listaAZ);

        Select filtro = new Select(driver.findElement(By.xpath("//select[@class=('product_sort_container')]")));
        filtro.selectByValue("za");

        List<WebElement> listaZA = driver.findElements(By.xpath("//div[@class='inventory_item']"));


        for(int i=0; i<listaAZ.size(); i++){
            lista1.add(listaAZ.get(i).getText());
            lista2.add(listaZA.get(i).getText());
        }

        Assert.assertEquals("FALLIDO, NO HA ORDENADO DE LA Z A LA A", lista1, lista2);

    }

    @Test
    public void testOrdenarPrecioMenorMayor() throws InterruptedException
    {
        List preciohilo = new ArrayList();
        List preciolohi = new ArrayList();

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        Select filtro1 = new Select(driver.findElement(By.xpath("//select[@class=('product_sort_container')]")));
        filtro1.selectByValue("lohi");
        List<WebElement> menorMayor1 = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));


        Select filtro2 = new Select(driver.findElement(By.xpath("//select[@class=('product_sort_container')]")));
        filtro2.selectByValue("hilo");
        List<WebElement> menorMayor2 = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        for(int i=0; i<menorMayor1.size(); i++){
            preciohilo.add(Double.parseDouble(menorMayor2.get(i).getText().substring(1, 5)));
            preciolohi.add(Double.parseDouble(menorMayor1.get(i).getText().substring(1, 5)));
        }

        Collections.sort(preciohilo);
        Assert.assertEquals("FALLIDO, NO HA ORDENADO DE MENOR A  MAYOR", preciohilo, preciolohi);

    }

    @Test
    public void testOrdenarPrecioMayorMenor() throws InterruptedException
    {
        List preciohilo = new ArrayList();
        List preciolohi = new ArrayList();

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        Select filtro1 = new Select(driver.findElement(By.xpath("//select[@class=('product_sort_container')]")));
        filtro1.selectByValue("lohi");
        List<WebElement> menorMayor1 = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        Select filtro2 = new Select(driver.findElement(By.xpath("//select[@class=('product_sort_container')]")));
        filtro2.selectByValue("hilo");
        List<WebElement> menorMayor2 = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));


        for(int i=0; i<menorMayor1.size(); i++){
            preciohilo.add(Double.parseDouble(menorMayor2.get(i).getText().substring(1, 5)));
            preciolohi.add(Double.parseDouble(menorMayor1.get(i).getText().substring(1, 5)));
        }

        Collections.sort(preciolohi, Collections.reverseOrder());
        Assert.assertEquals("FALLIDO, NO HA ORDENADO DE MAYOR A MENOR", preciohilo, preciolohi);

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
