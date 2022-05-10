package com.hiberus.university.selenium.inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

import javax.xml.datatype.Duration;
import java.util.concurrent.TimeUnit;


/**
 * Unit test for simple App.
 */
public class InventarioSuite {
    /**
     * Rigorous Test :-)
     */
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Random dado = new Random();

    @Before
    public void setUp() {
        //Paso0
        WebDriverManager.chromedriver().setup(); // Cargar Chromedriver

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 5, 500);
    }

    @Test
    public void testNumeroItems() throws InterruptedException {
        // 1
        driver.get("https://www.saucedemo.com/");
        // 2
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // 3
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // 4
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // 5
        List<WebElement> items;

        items = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@class='inventory_item']"))));

        Assert.assertEquals("LA PRUEBA A FALLADO PORQUE EL NUMERO DE ITEMS NO ES 6", 6, items.size());
    }

    @Test
    public void testExisteProductoSauce() throws InterruptedException {
        // 1
        driver.get("https://www.saucedemo.com/");
        // 2
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // 3
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // 4
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // 5

        boolean existe = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")))).isDisplayed();
        Thread.sleep(2000);
        Assert.assertTrue("EL PRODUCTO Sauce Labs Bolt T-Shirt NO ESTA EN EL INVENTARIO", existe);
    }

    @Test
    public void testAddProductoSauce() throws InterruptedException {
        // 1
        driver.get("https://www.saucedemo.com/");
        // 2
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // 3
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // 4
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // 5
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")))).click();
        } catch (NoSuchElementException e) {

        }
        // 6
        String numCarro = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")))).getText();
        Assert.assertEquals("EL PRODUCTO Sauce Labs Bolt T-Shirt NO SE HA AÑADIDO AL CARRO", "1", numCarro);
        Thread.sleep(2000);
    }

    @Test
    public void testRemoveProductoSauce() throws InterruptedException {
        // 1
        driver.get("https://www.saucedemo.com/");
        // 2
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // 3
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // 4
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // 5
        boolean existe;
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")))).click();
            Thread.sleep(1000);
            // 6
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")))).click();
            Thread.sleep(1000);
            // 7
            existe = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")))).isDisplayed();
        } catch (NoSuchElementException e) {
            existe = false;
        }

        Thread.sleep(2000);
        Assert.assertFalse("EL PRODUCTO Sauce Labs Bolt T-Shirt NO SE HA ELIMINADO AL CARRO", existe);
    }

    @Test
    public void testAddProductosSauce() throws InterruptedException {
        // 1
        driver.get("https://www.saucedemo.com/");
        // 2
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // 3
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // 4
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // 5
        int i = 0;
        while (i != 3) {
            Thread.sleep(1000);
            List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@class='inventory_list']/descendant::button[text()='Add to cart']"))));
            items.get(dado.nextInt(items.size())).click();
            i++;
        }
        // 6
        String numCarro;
        try {
            numCarro = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")))).getText();
        } catch (NoSuchElementException e) {
            numCarro = "";
        }
        Assert.assertEquals("EL PRODUCTO Sauce Labs Bolt T-Shirt NO SE HA AÑADIDO AL CARRO", "3", numCarro);
    }

    @Test
    public void testOrdenZASauce() throws InterruptedException {
        // 1
        driver.get("https://www.saucedemo.com/");
        // 2
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // 3
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // 4
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

        //6
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        String[] nombres = new String[6];

        for (int i = 0; i < items.size(); i++) {
            nombres[i] = items.get(i).getText();
        }

        // 5
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//option[@value='za']")))).click();

        //6
        List<WebElement> itemsInversos = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        String[] nombresInversos = new String[6];

        for (int i = 0; i < itemsInversos.size(); i++) {
            nombresInversos[i] = itemsInversos.get(i).getText();
        }

        Arrays.sort(nombres, Collections.reverseOrder());

        Assert.assertEquals("EL FILTRO 'Name (Z to A)', NO FUNCIONA CORRECTAMENTE. ", nombres, nombresInversos);
    }

    @Test
    public void testOrdenLowerToHighSauce() throws InterruptedException {
        // 1
        driver.get("https://www.saucedemo.com/");
        // 2
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // 3
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // 4
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // 6
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        Double[] precio = new Double[6];

        for (int i = 0; i < items.size(); i++) {
            precio[i] = Double.parseDouble(items.get(i).getText().substring(1));
        }

        // 5
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//option[@value='lohi']")))).click();

        // 6
        List<WebElement> itemsInversos = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        Double[] precioInversos = new Double[6];

        for (int i = 0; i < itemsInversos.size(); i++) {
            precioInversos[i] = Double.parseDouble(itemsInversos.get(i).getText().substring(1));
        }

        Arrays.sort(precio);

        Assert.assertEquals("EL FILTRO 'Name (Z to A)', NO FUNCIONA CORRECTAMENTE. ", precio, precioInversos);
    }

    @Test
    public void testOrdenHighToLowerSauce() throws InterruptedException {
        // 1
        driver.get("https://www.saucedemo.com/");
        // 2
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // 3
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // 4
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        // 6
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        Double[] precio = new Double[6];

        for (int i = 0; i < items.size(); i++) {
            precio[i] = Double.parseDouble(items.get(i).getText().substring(1));
        }

        // 5
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//option[@value='hilo']")))).click();

        // 6
        List<WebElement> itemsInversos = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        Double[] precioInversos = new Double[6];

        for (int i = 0; i < itemsInversos.size(); i++) {
            precioInversos[i] = Double.parseDouble(itemsInversos.get(i).getText().substring(1));
        }

        Arrays.sort(precio, Collections.<Double>reverseOrder());

        Assert.assertEquals("EL FILTRO 'Name (Z to A)', NO FUNCIONA CORRECTAMENTE. ", precio, precioInversos);
    }

    @After
    public void tearDawn() {
        driver.quit();
    }
}
