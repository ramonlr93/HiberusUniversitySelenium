package com.hiberus.university.selenium.inventario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.ObjectUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Inventario {

    public static WebDriver driver;

    @Before
    public void setupClass() {
        String userProfile = "C:\\Users\\pepet\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void validarNumeroResultados() {
        driver.get("https://www.saucedemo.com/");

        String username = "standard_user";
        String password = "secret_sauce";

        //driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        // declaramos la lista de los productos hijos del inventorylist
        List<WebElement> listaProductos = driver.findElements(By.xpath("//div[@class='inventory_list']/child::div"));

        //listaProductos.size(); es lo que tiene que ser igual funciona como un if ( el assert)
        Assert.assertEquals("El numero de produtcos no es igual a 6", 6, listaProductos.size());


    }

    @Test
    public void validarPdorcutoShirtInventario() {
        driver.get("https://www.saucedemo.com/");

        WebElement userBox = driver.findElement(By.id("user-name"));
        userBox.sendKeys("standard_user");

        WebElement passBox = driver.findElement(By.id("password"));
        passBox.sendKeys("secret_sauce");

        WebElement clickButton = driver.findElement(By.id("login-button"));
        clickButton.click();

        WebElement validarShirt = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Bolt T-Shirt']"));

        Assert.assertTrue("El producto Sauce Labs Bolt T-Shirt existe", validarShirt.isDisplayed());
    }

    @Test
    public void anadirShirtCarrito() {
        driver.get("https://www.saucedemo.com/");

        WebElement userBox = driver.findElement(By.id("user-name"));
        userBox.sendKeys("standard_user");

        WebElement passBox = driver.findElement(By.id("password"));
        passBox.sendKeys("secret_sauce");

        WebElement clickButton = driver.findElement(By.id("login-button"));
        clickButton.click();

        WebElement clickCamisa = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        clickCamisa.click();

        WebElement validarCarro = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        String carrito = validarCarro.getText();
        Assert.assertEquals("El carrito NO tiene un producto", "1", carrito);

    }

    @Test
    public void eliminarProductoCarrito() {
        driver.get("https://www.saucedemo.com/");

        WebElement userBox = driver.findElement(By.id("user-name"));
        userBox.sendKeys("standard_user");

        WebElement passBox = driver.findElement(By.id("password"));
        passBox.sendKeys("secret_sauce");

        WebElement clickButton = driver.findElement(By.id("login-button"));
        clickButton.click();

        WebElement clickCamisa = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        clickCamisa.click();

        WebElement botonRemove = driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"));
        botonRemove.click();

        WebElement validarIcono = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        String valoractual = validarIcono.getText();
        String valoresperado = "";

        Assert.assertEquals("El carro SI tiene productos actualmente", valoresperado, valoractual);

    }

    @Test
    public void anadirProductosCarro() {
        driver.get("https://www.saucedemo.com/");

        WebElement userBox = driver.findElement(By.id("user-name"));
        userBox.sendKeys("standard_user");

        WebElement passBox = driver.findElement(By.id("password"));
        passBox.sendKeys("secret_sauce");

        WebElement clickButton = driver.findElement(By.id("login-button"));
        clickButton.click();

        WebElement clickCamisa = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        clickCamisa.click();
        WebElement clickBackpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        clickBackpack.click();
        WebElement clickBike = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        clickBike.click();



        WebElement seleccionarCantidad = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        String valoractual = seleccionarCantidad.getText();
        String valoresperado = "3";


        Assert.assertEquals("El carro No tiene productos seleccionados", valoresperado, valoractual);

    }


    @Test
    public void ordenarInventarioAlfabeticamente() {
        driver.get("https://www.saucedemo.com/");

        WebElement userBox = driver.findElement(By.id("user-name"));
        userBox.sendKeys("standard_user");

        WebElement passBox = driver.findElement(By.id("password"));
        passBox.sendKeys("secret_sauce");

        WebElement clickButton = driver.findElement(By.id("login-button"));
        clickButton.click();

        WebElement selector = driver.findElement(By.xpath("//option[@value='az'']"));
        //select[@class='product_shrt_container']



    }




    @After
    public void tearDom() {
        driver.quit();
    }
}
