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
import java.util.concurrent.TimeUnit;

public class CheckoutSuite {

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

    @Test
    public void testPrecioFinal() throws InterruptedException
    {

        double totalUno = 0.0;
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("Fulanito");
        driver.findElement(By.id("last-name")).sendKeys("Fulanitez");
        driver.findElement(By.id("postal-code")).sendKeys("55555");

        driver.findElement(By.id("continue")).click();

        List<WebElement> precio = driver.findElements(By.xpath("//div[@class = 'inventory_item_prince']"));

        for (int i=0; i<precio.size();i++){
            totalUno += (Double.parseDouble(precio.get(i).getText().substring(1, 5)));
        }

        double totalDos = Double.parseDouble(driver.findElement(By.xpath("//div[@class = 'summary_subtotal_label']")).getText().substring(13));

        Assert.assertEquals("PREUBA FALLIDA", totalDos, totalUno);
    }

    @Test
    public void testRealizarPedido() throws InterruptedException
    {
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("Fulanito");
        driver.findElement(By.id("last-name")).sendKeys("Fulanitez");
        driver.findElement(By.id("postal-code")).sendKeys("55555");

        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("final")).click();

        boolean isMessageVisible = driver.findElement(By.xpath("//div[@class='complete-text']")).isDisplayed();

        Assert.assertTrue("PRUEBA FALLIDA, NO SE HA COMPLETADO EL PEDIDO", isMessageVisible);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
