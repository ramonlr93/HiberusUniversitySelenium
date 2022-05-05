package com.hiberus.university.selenium.checkout;

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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckoutSuite {

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
    public void comprobarPrecioFinal() {
        WebElement usuario;
        WebElement passwrod;
        WebElement boton;
        WebElement carrito;
        List<WebElement> botonAdd;
        List<WebElement> objetosCarrito;
        String precio;
        float precioInventario=0;
        int valorAleatorio;
        int valorAleatorio2;
        int valorAleatorio3;
        driver.get("https://www.saucedemo.com");
        usuario = driver.findElement(By.id("user-name"));
        passwrod = driver.findElement(By.id("password"));
        boton = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        passwrod.sendKeys("secret_sauce");
        boton.click();
        botonAdd=driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        valorAleatorio = (int) (Math.random()*botonAdd.size());
        botonAdd.get(valorAleatorio).click();
        valorAleatorio2 = (int) (Math.random()*botonAdd.size());
        if(valorAleatorio2!=valorAleatorio){
            botonAdd.get(valorAleatorio2).click();
        }else{
            while(valorAleatorio2==valorAleatorio){
                valorAleatorio2 = (int) (Math.random()*botonAdd.size());;
            }
            botonAdd.get(valorAleatorio2).click();
        }
        valorAleatorio3 = (int) (Math.random()*botonAdd.size());
        if(valorAleatorio3!=valorAleatorio && valorAleatorio3!=valorAleatorio2){
            botonAdd.get(valorAleatorio3).click();
        }else{
            while(valorAleatorio3==valorAleatorio || valorAleatorio3==valorAleatorio2 ){
                valorAleatorio3 = (int) (Math.random()*botonAdd.size());;
            }
            botonAdd.get(valorAleatorio3).click();
        }
        carrito = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        carrito.click();
        objetosCarrito = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (WebElement elemento : objetosCarrito) {
            String texto = elemento.getText();
            texto = texto.replace("$","");
            precioInventario+=Float.parseFloat(texto);
        }
        driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']")).click();
        driver.findElement(By.id("first-name")).sendKeys("Roberto");
        driver.findElement(By.id("last-name")).sendKeys("Teresa");
        driver.findElement(By.id("postal-code")).sendKeys("47250");
        driver.findElement(By.id("continue")).click();
        precio = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText();
        precio = precio.replace("Item total: $","");
        Assert.assertEquals("Precio no esta bien calculado",precioInventario,Float.parseFloat(precio),0.01);
    }

    @Test
    public void realizarUnPedido()  {
        WebElement usuario;
        WebElement passwrod;
        WebElement boton;
        WebElement carrito;
        List<WebElement> botonAdd;
        int valorAleatorio;
        driver.get("https://www.saucedemo.com");
        usuario = driver.findElement(By.id("user-name"));
        passwrod = driver.findElement(By.id("password"));
        boton = driver.findElement(By.id("login-button"));
        usuario.sendKeys("standard_user");
        passwrod.sendKeys("secret_sauce");
        boton.click();
        botonAdd=driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        valorAleatorio = (int) (Math.random()*botonAdd.size());
        botonAdd.get(valorAleatorio).click();
        carrito = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        carrito.click();
        driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']")).click();
        driver.findElement(By.id("first-name")).sendKeys("Roberto");
        driver.findElement(By.id("last-name")).sendKeys("Teresa");
        driver.findElement(By.id("postal-code")).sendKeys("47250");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        Assert.assertEquals("No se realizo el pedido correctamente","Your order has been dispatched, and will arrive just as fast as the pony can get there!",driver.findElement(By.xpath("//div[@class='complete-text']")).getText());
    }


    @After
    public void clsoeDriver() {
        driver.close();
    }

}
