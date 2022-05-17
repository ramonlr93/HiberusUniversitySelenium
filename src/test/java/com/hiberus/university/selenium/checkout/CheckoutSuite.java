package com.hiberus.university.selenium.checkout;

import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckoutSuite {

    public static WebDriver driver;

    public static WebDriverWait wait;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);
        PagesFactory.start(driver);
        driver.get(LoginPage.PAGE_URL);
    }

    @Test
    public void testPrecioFinal() throws InterruptedException
    {

        //double totalUno = 0.0;
        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        //driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        //driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        //driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        //driver.findElement(By.id("checkout")).click();

        //driver.findElement(By.id("first-name")).sendKeys("Fulanito");
        //driver.findElement(By.id("last-name")).sendKeys("Fulanitez");
        //driver.findElement(By.id("postal-code")).sendKeys("55555");

        //driver.findElement(By.id("continue")).click();

        //List<WebElement> precio = driver.findElements(By.xpath("//div[@class = 'inventory_item_prince']"));

        //for (int i=0; i<precio.size();i++){
         //   totalUno += (Double.parseDouble(precio.get(i).getText().substring(1, 5)));
        //}

        //double totalDos = Double.parseDouble(driver.findElement(By.xpath("//div[@class = 'summary_subtotal_label']")).getText().substring(13));

        //Assert.assertEqu

        List<WebElement> inventario = driver.findElements(By.xpath("//button[contains(@id, 'add-to-cart')]"));

        ArrayList<Integer> selectValue = new ArrayList();
        int pos;
        int count = 0;
        for (int i=0; i< inventario.size(); i++){
            pos = (int) Math.floor(Math.random() * inventario.size());

            while (selectValue.contains(pos)){
                pos = (int) Math.floor(Math.random() * inventario.size());
            }

            if (count < 3) {
                selectValue.add(pos);
                count++;
            }
        }

        List<String> listaProductos = new ArrayList<String>();
        for (int i=0; i<selectValue.size(); i++){
            listaProductos.add(inventario.get(selectValue.get(i)).findElement(By.xpath(".//preceding-sibling::div[@class='inventory_item_price']")).getText());
            inventario.get(selectValue.get(i)).click();
        }

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("Fulanito");
        driver.findElement(By.id("last-name")).sendKeys("Fulanitez");
        driver.findElement(By.id("postal-code")).sendKeys("55555");
        driver.findElement(By.id("continue")).click();

        List<Double> precioProducto = new ArrayList();

        for (int i=0; i<listaProductos.size(); i++){
            precioProducto.add(Double.parseDouble(listaProductos.get(i).replace("$", "").trim()));
        }

        double value = 0;

        for (int i=0; i< precioProducto.size(); i++){
            value += precioProducto.get(i);
        }

        String valorTotal = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText();
        valorTotal = valorTotal.replace("Item total: $", "").trim();

        Assert.assertEquals("PRUEBA FALLIDA, LA SUMA DE LOS DOS NO ES LA MISMA", String.valueOf(value), String.valueOf(value));

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
        driver.findElement(By.id("finish")).click();

        boolean isMessageVisible = driver.findElement(By.xpath("//div[@class='complete-text']")).isDisplayed();

        Assert.assertTrue("PRUEBA FALLIDA, NO SE HA COMPLETADO EL PEDIDO", isMessageVisible);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
