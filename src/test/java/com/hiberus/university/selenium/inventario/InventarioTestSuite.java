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
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class InventarioTestSuite {


    public static WebDriver driver;

    @Before
    public void SetUp() {
        String userProfile = "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup(); // cargar Chromedriver
        ChromeOptions options = new ChromeOptions(); // Crear instancia para opciones de chrome
        options.addArguments("user-data-dir=" + userProfile);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void validarInventario()  {


        driver.get("https://www.saucedemo.com");
        WebElement usuario = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement boton = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        boton.click();
        List<WebElement> inventario = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        if(inventario.size()==6){
            System.out.println("La cantidad de productos es 6");
        }else{
            System.out.println("La cantidad de productos NO es 6");
        }
    }
    @Test
    public void testExistenciaProducto() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        WebElement numeroCarrito = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
        if(numeroCarrito.isDisplayed()){
            System.out.println("cagadon pa ti");
        }
        else{
            System.out.println("ñao ñao");
        }

    }
    @Test
    public void testCarrito() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        WebElement numeroCarrito = driver.findElement(By.xpath("//span[@class ='shopping_cart_badge']"));
        if(numeroCarrito.isDisplayed()){
            System.out.println("cagadon pa ti");
        }
        else{
            System.out.println("ñao ñao");
        }

    }
    @Test
    public void validarAñdirCarritoYEliminar()   {
        driver.get("https://www.saucedemo.com");
        WebElement usuario = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement botonLogin = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        botonLogin.click();
        WebElement botonAdd =driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        botonAdd.click();
        WebElement botonRemove = driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"));
        botonRemove.click();
        List<WebElement> carritoCompra = driver.findElements(By.xpath("//a[@class='shopping_cart_link']//child::*"));
        Assert.assertEquals("El test ha fallado",carritoCompra.size(),0);
    }
    @Test
    public void añadir3ProductosCarrito()   {
        driver.get("https://www.saucedemo.com");
        WebElement usuario = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement botonLogin = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        botonLogin.click();
        List<WebElement> botonesAddCart =driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        for (int i=0;i<2;i++){
            botonesAddCart.get(i).click();
        }
        List<WebElement> carrito = driver.findElements(By.xpath("//a[@class='shopping_cart_link']//child::*"));
        Assert.assertEquals("Testfallido, no se han añadido los productos correctamente",carrito.get(0).getText(),"3");
    }
    @Test
    public void ordenarInventarioAlfabeticamente()   {
        driver.get("https://www.saucedemo.com");
        WebElement usuario = driver.findElement(By.id("user-name"));
        WebElement passwrod = driver.findElement(By.id("password"));
        WebElement boton = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        passwrod.sendKeys("secret_sauce");
        boton.click();
        //se introduce todos los elementos en un lista ordenados de A-Z default y se da la vuelta a la lista con el .reverse
        List<WebElement> inventario = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        Collections.reverse(inventario);
        //el select es el filtro que aparece en la pagina web
        Select selector = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selector.selectByVisibleText("Name (Z to A)");
        //se mete lo filtrado en un lista
        List<WebElement> inventarioInverso = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        Assert.assertEquals("No se ordeno correctamente",inventario,inventarioInverso);
    }
    @Test
    public void ordenarInventarioMenorAMayorPrecio()   {
        List<String> precios=new ArrayList<String>();
        List<String> preciosInversos=new ArrayList<String>();

        driver.get("https://www.saucedemo.com");
        WebElement usuario = driver.findElement(By.id("user-name"));
        WebElement passwrod = driver.findElement(By.id("password"));
        WebElement boton = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        passwrod.sendKeys("secret_sauce");
        boton.click();
        Select selector = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selector.selectByValue("hilo");
        List<WebElement> inventario = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        //forecach que va metiendo el texto de cada elemento de los precios a una lista de string
        for (WebElement elemento : inventario) {
            precios.add(elemento.getText());
        }
        Collections.reverse(precios);
        selector = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selector.selectByValue("lohi");
        List<WebElement> inventarioInverso = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (WebElement precios1 : inventarioInverso) {
            preciosInversos.add(precios1.getText());
        }
        Assert.assertEquals("No se ordenaron correctamente los precios",precios,preciosInversos);

    }
    @Test
    public void ordenarInventarioMayorAMenorPrecio()   {
        List<String> precios=new ArrayList<String>();
        List<String> preciosInversos=new ArrayList<String>();

        driver.get("https://www.saucedemo.com");
        WebElement usuario = driver.findElement(By.id("user-name"));
        WebElement passwrod = driver.findElement(By.id("password"));
        WebElement boton = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        passwrod.sendKeys("secret_sauce");
        boton.click();
        Select selector = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selector.selectByValue("lohi");
        List<WebElement> inventario = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        //forecach que va metiendo el texto de cada elemento de los precios a una lista de string
        for (WebElement elemento : inventario) {
            precios.add(elemento.getText());
        }
        Collections.reverse(precios);
        selector = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selector.selectByValue("hilo");
        List<WebElement> inventarioInverso = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (WebElement precios1 : inventarioInverso) {
            preciosInversos.add(precios1.getText());
        }
        Assert.assertEquals("No se ordenaron correctamente los precios",precios,preciosInversos);

    }

    @After
    public void quitDriver(){
        driver.quit();
    }
}