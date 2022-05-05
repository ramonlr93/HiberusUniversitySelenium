package com.hiberus.university.selenium.checkOut;

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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckOutTestSuite {
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
    public void comprobarPrecioFinalProductos(){
        driver.get("https://www.saucedemo.com");
        WebElement usuario = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement botonLogin = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        botonLogin.click();
        List<WebElement> botonesAddCart =driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        for (int i=0;i<3;i++){
            botonesAddCart.get(i).click();
        }
        WebElement carritoCompraBtn = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        carritoCompraBtn.click();

        WebElement btnChekOut = driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']"));
        btnChekOut.click();

        WebElement nombre = driver.findElement(By.id("first-name"));
        WebElement apellido = driver.findElement(By.id("last-name"));
        WebElement codigoPostal = driver.findElement(By.id("postal-code"));
        nombre.sendKeys("javier");
        apellido.sendKeys("sanchez");
        codigoPostal.sendKeys("47400");

        WebElement finCompra = driver.findElement(By.id("continue"));
        finCompra.click();

        List<WebElement> precios =driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        float sumatorio=0;

        for(int i=0;i<3;i++){
            String textoPrecio = precios.get(i).getText();
            textoPrecio=textoPrecio.replace("$","");
            sumatorio+=Float.parseFloat(textoPrecio);
        }

        WebElement precioTotal = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        String texto = precioTotal.getText();
        texto=texto.replace("Item total: $","");
        float totalPrecios = Float.parseFloat(texto);

        Assert.assertEquals("Testfallido, no sonn el mismo precio",totalPrecios,sumatorio,0.01);

    }
    @Test
    public void realiozarPedido(){
        driver.get("https://www.saucedemo.com");
        WebElement usuario = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement botonLogin = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        botonLogin.click();
        List<WebElement> botonesAddCart =driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        for (int i=0;i<1;i++){
            botonesAddCart.get(i).click();
        }
        WebElement carritoCompraBtn = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        carritoCompraBtn.click();

        WebElement btnChekOut = driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']"));
        btnChekOut.click();

        WebElement nombre = driver.findElement(By.id("first-name"));
        WebElement apellido = driver.findElement(By.id("last-name"));
        WebElement codigoPostal = driver.findElement(By.id("postal-code"));
        nombre.sendKeys("javier");
        apellido.sendKeys("sanchez");
        codigoPostal.sendKeys("47400");

        WebElement irFinCompra = driver.findElement(By.id("continue"));
        irFinCompra.click();

        WebElement finCompra = driver.findElement(By.id("finish"));
        finCompra.click();

        WebElement compraCorrecta = driver.findElement(By.xpath("//div[@class='complete-text']"));
        String fraseCompraCorrecta = compraCorrecta.getText();

        String comprobacion = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

        Assert.assertEquals("Testfallido, no es la misma frase",fraseCompraCorrecta,comprobacion);

    }
    @After
    public void quitDriver(){
        driver.quit();
    }
}
