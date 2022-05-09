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

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class CheckoutSuiteTest {
    public static WebDriver driver;

    @Before
    public void tearUp() {
        String userProfile= "C:\\Users\\pue\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void precioFinal() throws InterruptedException {

        double totalPrecio = 0;

        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Seleccionar 3 productos
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //Ir al carrito
        driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).click();

        //Click en checkout
        driver.findElement(By.id("checkout")).click();

        //Rellenar formulario
        driver.findElement(By.id("first-name")).sendKeys("Monica");
        driver.findElement(By.id("lastName")).sendKeys("Lamas");
        driver.findElement(By.id("postal-code")).sendKeys("15220");

        //Continuar
        driver.findElement(By.id("continue")).click();

        //Validar precios
        List<WebElement> itemsPrice = driver.findElements(By.xpath("//div[@class = 'inventory_item_price']"));


        for(int i=0;i<itemsPrice.size();i++){
            totalPrecio += (Double.parseDouble(itemsPrice.get(i).getText().substring(1,6)));
        }

        String sumarySubtotal = driver.findElement(By.xpath("//div[@class = 'summary_subtotal_label']")).getText();
        String webTotal = (sumarySubtotal.substring(13, sumarySubtotal.length()));

        // Validamos que el precio es igual
        Assert.assertEquals( "PRUEBA FALLIDA, EL PRECIO ES DIFERENTE", Double.toString(totalPrecio), webTotal);

        //Finalizar
        driver.findElement(By.id("finish")).click();

    }

    @Test
    public void realizarPedido() throws InterruptedException {

        String completeText = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Seleccionar 1 producto
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        //Ir al carrito
        driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).click();

        //Click en checkout
        driver.findElement(By.id("checkout")).click();

        //Rellenar formulario
        driver.findElement(By.id("first-name")).sendKeys("Monica");
        driver.findElement(By.id("lastName")).sendKeys("Lamas");
        driver.findElement(By.id("postal-code")).sendKeys("15220");

        //Continuar
        driver.findElement(By.id("continue")).click();

        //Finalizar
        driver.findElement(By.id("finish")).click();

        // Validamos pedido finalizado

        String okComplete = driver.findElement(By.xpath("//div[@class = 'complete-text']")).getText();

        // Validamos que se ha realizado correctamente
        Assert.assertEquals( "PRUEBA FALLIDA, EL MENSAJE ES DIFERENTE O NO EXISTE", completeText, okComplete);

    }


    @After
    public void tearDown() {
        driver.quit();
    }

}