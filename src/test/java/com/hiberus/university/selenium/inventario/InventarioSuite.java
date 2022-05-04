package com.hiberus.university.selenium.inventario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
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


    @Before
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void validarInventario()  {
        WebElement usuario;
        WebElement passwrod;
        WebElement boton;
        List<WebElement> inventario;
        driver.get("https://www.saucedemo.com");
        usuario = driver.findElement(By.id("user-name"));
        passwrod = driver.findElement(By.id("password"));
        boton = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        passwrod.sendKeys("secret_sauce");
        boton.click();
        inventario = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        Assert.assertEquals("El inventario no son 6 objetos", inventario.size(), 6);
    }

    @Test
    public void validarProductoInventario()  {
        WebElement usuario;
        WebElement passwrod;
        WebElement boton;
        List<WebElement> inventario;
        boolean check=false;
        driver.get("https://www.saucedemo.com");
        usuario = driver.findElement(By.id("user-name"));
        passwrod = driver.findElement(By.id("password"));
        boton = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        passwrod.sendKeys("secret_sauce");
        boton.click();
        inventario = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        for (WebElement a : inventario) {
            if (a.getText().equals("Sauce Labs Bolt T-Shirt")) {
                check=true;
            }
        }
        Assert.assertTrue("No esta en el inventario",check);
    }

    @Test
    public void validarAñadirCarrito() {
        WebElement usuario;
        WebElement passwrod;
        WebElement boton;
        WebElement botonAdd;
        List<WebElement> carrito;
        driver.get("https://www.saucedemo.com");
        usuario = driver.findElement(By.id("user-name"));
        passwrod = driver.findElement(By.id("password"));
        boton = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        passwrod.sendKeys("secret_sauce");
        boton.click();
        botonAdd=driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        botonAdd.click();
        carrito = driver.findElements(By.xpath("//a[@class='shopping_cart_link']//child::*"));
        Assert.assertNotEquals("No se añadio y borrado del carrito",carrito.size(),0);
    }

    @Test
    public void validarAñdirCarritoYEliminar()   {
        WebElement usuario;
        WebElement passwrod;
        WebElement boton;
        WebElement botonAdd;
        WebElement botonRemove;
        List<WebElement> carrito;
        driver.get("https://www.saucedemo.com");
        usuario = driver.findElement(By.id("user-name"));
        passwrod = driver.findElement(By.id("password"));
        boton = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        passwrod.sendKeys("secret_sauce");
        boton.click();
        botonAdd = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        botonAdd.click();
        botonRemove = driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"));
        botonRemove.click();
        carrito = driver.findElements(By.xpath("//a[@class='shopping_cart_link']//child::*"));
        Assert.assertEquals("No se añadio y borrado del carrito",carrito.size(),0);
    }

    @Test
    public void agregar3Productos()   {
        WebElement usuario;
        WebElement passwrod;
        WebElement boton;
        List<WebElement> botonAdd;
        List<WebElement> carrito;
        driver.get("https://www.saucedemo.com");
        usuario = driver.findElement(By.id("user-name"));
        passwrod = driver.findElement(By.id("password"));
        boton = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        passwrod.sendKeys("secret_sauce");
        boton.click();
        botonAdd=driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        for (int a=0;a<3;a++){
            botonAdd.get(a).click();
        }
        carrito = driver.findElements(By.xpath("//a[@class='shopping_cart_link']//child::*"));
        Assert.assertEquals("No se añadio y borrado del carrito",carrito.get(0).getText(),"3");
    }

    @Test
    public void ordenarInventarioAlfabeticamente()   {
        WebElement usuario;
        WebElement passwrod;
        WebElement boton;
        List<WebElement> inventario;
        List<WebElement> inventarioInverso;
        Select selector;
        driver.get("https://www.saucedemo.com");
        usuario = driver.findElement(By.id("user-name"));
        passwrod = driver.findElement(By.id("password"));
        boton = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        passwrod.sendKeys("secret_sauce");
        boton.click();
        inventario = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        Collections.reverse(inventario);
        selector = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selector.selectByVisibleText("Name (Z to A)");
        inventarioInverso = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        Assert.assertEquals("No se ordeno correctamente",inventario,inventarioInverso);
    }


    @Test
    public void ordenarInventarioMenorAMayor()   {
        WebElement usuario;
        WebElement passwrod;
        WebElement boton;
        List<WebElement> inventario;
        List<String> precios=new ArrayList<String>();
        List<WebElement> inventarioInverso;
        List<String> preciosInversos=new ArrayList<String>();
        Select selector;
        driver.get("https://www.saucedemo.com");
        usuario = driver.findElement(By.id("user-name"));
        passwrod = driver.findElement(By.id("password"));
        boton = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        passwrod.sendKeys("secret_sauce");
        boton.click();
        selector = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selector.selectByValue("hilo");
        inventario = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (WebElement elemento : inventario) {
            precios.add(elemento.getText());
        }
        Collections.reverse(precios);
        selector = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selector.selectByValue("lohi");
        inventarioInverso = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (WebElement elemento : inventarioInverso) {
            preciosInversos.add(elemento.getText());
        }
        Assert.assertEquals("No se ordeno correctamente",precios,preciosInversos);

    }

    @Test
    public void ordenarInventarioMayorAMenor()   {
        WebElement usuario;
        WebElement passwrod;
        WebElement boton;
        List<WebElement> inventario;
        List<String> precios=new ArrayList<String>();
        List<WebElement> inventarioInverso;
        List<String> preciosInversos=new ArrayList<String>();
        Select selector;
        driver.get("https://www.saucedemo.com");
        usuario = driver.findElement(By.id("user-name"));
        passwrod = driver.findElement(By.id("password"));
        boton = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        passwrod.sendKeys("secret_sauce");
        boton.click();
        selector = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selector.selectByValue("lohi");
        inventario = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (WebElement elemento : inventario) {
            precios.add(elemento.getText());
        }
        Collections.reverse(precios);
        selector = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selector.selectByValue("hilo");
        inventarioInverso = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (WebElement elemento : inventarioInverso) {
            preciosInversos.add(elemento.getText());
        }
        Assert.assertEquals("No se ordeno correctamente",precios,preciosInversos);
    }

    @After
    public void clsoeDriver() {
        driver.close();
    }
}